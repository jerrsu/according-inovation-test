package com.test.master.repository;

import com.test.master.model.Vehicle;
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
