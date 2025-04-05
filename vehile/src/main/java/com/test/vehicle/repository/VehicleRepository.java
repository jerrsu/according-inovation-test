package com.test.vehicle.repository;

import com.test.vehicle.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author jerrySuparman
 */

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
    Page<Vehicle> findAll(Pageable pageable);
    Page<Vehicle> findByStatusId(Integer statusId, Pageable pageable);
}
