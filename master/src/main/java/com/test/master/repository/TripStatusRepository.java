package com.test.master.repository;

import com.test.master.model.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jerrySuparman
 */

@Repository
public interface TripStatusRepository extends JpaRepository<TripStatus, Integer> {
}