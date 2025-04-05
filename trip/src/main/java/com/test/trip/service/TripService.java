package com.test.trip.service;

import com.test.trip.dto.Vehicle;
import com.test.trip.model.Trip;
import com.test.trip.repository.TripRepository;
import com.test.trip.dto.TripResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author jerrySuparman
 */
@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    private VehicleClient vehicleClient;

    public TripResponse mapToTripResponse(Trip trip) {
        return new TripResponse(trip.getId(),trip.getVehicleId(),trip.getStartLocation(),trip.getEndLocation(),trip.getStatusId(),trip.getCreatedAt(),trip.getUpdatedAt(),null,null);
    }

    public void sendKafkaMessage(String topic, String id) {
        kafkaTemplate.send(topic, id);
    }

    @Transactional
    public Trip createTrip(Trip trip) {
        Vehicle vehicle = vehicleClient.getVehicleById(trip.getVehicleId());
        if (vehicle.getStatusId() != 2) {
            trip.setStatusId(2);
            sendKafkaMessage("startTrip", String.valueOf(trip.getVehicleId()));
            return tripRepository.save(trip);
        }
        return null;
    }

    @Transactional
    public Trip closeTrip(String id) {
        Trip oldTrip = findTripById(id);
        if (oldTrip.getStatusId() == 2) {
            oldTrip.setStatusId(3);
            sendKafkaMessage("endTrip", String.valueOf(oldTrip.getVehicleId()));
            return tripRepository.save(oldTrip);
        }
        return null;
    }

    public Trip findTripById(String id) {
        return tripRepository.findById(UUID.fromString(id)).orElse(null);
    }

    public Page<TripResponse> findAllTrips(Pageable pageable) {
        return tripRepository.findAll(pageable).map(map -> {
            TripResponse tripResponse = mapToTripResponse(map);
            tripResponse.setDetailVehicle(vehicleClient.getVehicleById(tripResponse.getVehicleId()));
            tripResponse.setDetailStatus(vehicleClient.getStatusById(tripResponse.getStatusId()));
            return tripResponse;
        });
    }

    @CacheEvict(value = "trip",key = "#status")
    public Page<TripResponse> findByStatusId(Integer status, Pageable pageable) {
        return tripRepository.findByStatusId(status,pageable).map(map -> {
            TripResponse tripResponse = mapToTripResponse(map);
            tripResponse.setDetailVehicle(vehicleClient.getVehicleById(tripResponse.getVehicleId()));
            tripResponse.setDetailStatus(vehicleClient.getStatusById(status));
            return tripResponse;
        });
    }
}
