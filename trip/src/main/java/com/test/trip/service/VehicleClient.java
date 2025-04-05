package com.test.trip.service;

import ch.qos.logback.core.status.Status;
import com.test.trip.dto.TripStatus;
import com.test.trip.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author jerrySuparman
 */
@Service
public class VehicleClient {
    @Autowired
    private RestTemplate restTemplate;

    public Vehicle getVehicleById(UUID vehicleId) {
        String VEHICLE_SERVICE_URL = "http://172.17.0.1:18080/vehicle/";
        return restTemplate.getForObject(VEHICLE_SERVICE_URL + vehicleId, Vehicle.class);
    }

    public TripStatus getStatusById(Integer statusId) {
        String STATUS_SERVICE_URL = "http://172.17.0.1:18080/status/";
        return restTemplate.getForObject(STATUS_SERVICE_URL + statusId, TripStatus.class);
    }

}
