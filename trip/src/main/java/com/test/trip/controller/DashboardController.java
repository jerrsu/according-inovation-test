package com.test.trip.controller;

import com.test.trip.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jerrySuparman
 */

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/status-summary-monthly")
    public ResponseEntity<?> getTripStatusSummary(@RequestParam String periode) {
        return ResponseEntity.ok(dashboardService.getCountTripsByStatus(periode));
    }

    @GetMapping("/trips-monthly")
    public ResponseEntity<?> getCountTripsMonthly(@RequestParam String periode) {
        return ResponseEntity.ok(dashboardService.getCountTripsMonthly(periode));
    }

    @GetMapping("/trend-monthly")
    public ResponseEntity<?> getTrendTripsMonthly(@RequestParam String periode,@RequestParam Integer statusId) {
        return ResponseEntity.ok(dashboardService.getTrendTrip(periode,statusId));
    }

}
