package com.test.trip.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.trip.service.VehicleClient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author jerrySuparman
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripResponse implements Serializable {
    private UUID id;
    private UUID vehicleId;
    private String startLocation;
    private String endLocation;
    private Integer statusId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Vehicle detailVehicle;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TripStatus detailStatus;
}
