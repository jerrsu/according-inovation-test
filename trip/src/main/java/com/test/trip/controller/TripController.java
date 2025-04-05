package com.test.trip.controller;


import com.test.trip.model.Trip;
import com.test.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



/**
 * @author jerrySuparman
 */
@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private TripService tripService;

    @GetMapping
    public ResponseEntity<?> getAllTrips(@RequestParam(required = false) Integer statusId, Pageable pageable) {
        if (statusId != null) {
            return new ResponseEntity<>(tripService.findByStatusId(statusId,pageable), HttpStatus.OK);
        }
        return new ResponseEntity<>(tripService.findAllTrips(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addTrip(@RequestBody Trip trip) {
        try{
            Trip result = tripService.createTrip(trip);
            if (result != null) {
                return new ResponseEntity<>(result, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Vehicle status is ON GOING", HttpStatus.UNPROCESSABLE_ENTITY);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> closeTrip(@PathVariable String id) {
        Trip oldTrip = tripService.findTripById(id);
        if (oldTrip != null) {
            Trip trip = tripService.closeTrip(id);
            if (trip != null) {
                return new ResponseEntity<>(trip, HttpStatus.OK);
            }
            return new ResponseEntity<>("Trip status is DONE", HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
