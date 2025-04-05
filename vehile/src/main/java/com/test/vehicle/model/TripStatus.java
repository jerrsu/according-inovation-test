package com.test.vehicle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jerrySuparman
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trip_status")
public class TripStatus implements Serializable {
    @Id
    @Column(unique = true, nullable = false)
    private Integer id;
    private String status;
}
