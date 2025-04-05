package com.test.trip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jerrySuparman
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripStatus implements Serializable {
    private String status;
}
