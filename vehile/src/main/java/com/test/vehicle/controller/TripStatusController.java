package com.test.vehicle.controller;

import com.test.vehicle.model.TripStatus;
import com.test.vehicle.repository.TripStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author jerrySuparman
 */
@RestController
@RequestMapping("/status")
public class TripStatusController {
    @Autowired
    private TripStatusRepository tripStatusRepository;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<TripStatus> tripStatuses = tripStatusRepository.findAll();
        return new ResponseEntity<>(tripStatuses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Optional<TripStatus> tripStatus = tripStatusRepository.findById(id);
        if (tripStatus.isPresent()) {
            return new ResponseEntity<>(tripStatus.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
