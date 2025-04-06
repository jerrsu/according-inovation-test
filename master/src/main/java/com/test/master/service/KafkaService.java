package com.test.master.service;

import com.test.master.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author jerrySuparman
 */
@Service
public class KafkaService {
    @Autowired
    private VehicleService vehicleService;

    @KafkaListener(topics = "startTrip", groupId = "vehicle-service")
    public String listenStartTrip(String message) {
        Vehicle vehicle = vehicleService.getVehicleById(message);
        if (vehicle != null) {
            vehicleService.updateVehicleStatus(String.valueOf(vehicle.getId()),2);
            return "success";
        }
        return "fail";
    }

    @KafkaListener(topics = "endTrip", groupId = "vehicle-service")
    public String listenEndTrip(String message) {
        Vehicle vehicle = vehicleService.getVehicleById(message);
        if (vehicle != null) {
            vehicleService.updateVehicleStatus(String.valueOf(vehicle.getId()),1);
            return "success";
        }
        return "fail";
    }
}
