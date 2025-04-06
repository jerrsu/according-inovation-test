package com.test.master.controller;

import com.test.master.model.Vehicle;
import com.test.master.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author jerrySuparman
 */

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle newVehicle = vehicleService.addVehicle(vehicle);
            return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable String id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<?> getAllVehicles(@RequestParam(required = false) Integer statusId, Pageable pageable) {
        if (statusId != null) {
            return new ResponseEntity<>(vehicleService.findByStatus(statusId,pageable), HttpStatus.OK);
        }
        return new ResponseEntity<>(vehicleService.getAllVehicles(pageable), HttpStatus.OK);
    }

}
