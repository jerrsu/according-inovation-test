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
public class Vehicle implements Serializable {
    private String plateNumber;
    private String model;
    private Integer statusId;
}
