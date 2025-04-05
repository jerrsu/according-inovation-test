package com.test.vehicle.service;

import com.test.vehicle.model.Vehicle;
import com.test.vehicle.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author jerrySuparman
 */

@Slf4j
@Service
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicle.setStatusId(1);
        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(String id) {
        return vehicleRepository.findById(UUID.fromString(id)).orElse(null);
    }

    public Page<Vehicle> getAllVehicles(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }

    @CacheEvict(value = "vehicle", key = "#status")
    public Page<Vehicle> findByStatus(Integer status, Pageable pageable) {
        Page<Vehicle> vehicles = vehicleRepository.findByStatusId(status,pageable);
        return vehicles;
    }

    @Transactional
    public Vehicle updateVehicleStatus(String id, Integer statusId) {
        Vehicle oldVehicle = this.getVehicleById(id);
        if (oldVehicle != null) {
            oldVehicle.setStatusId(statusId);
            return vehicleRepository.save(oldVehicle);
        }
        return null;
    }


}
