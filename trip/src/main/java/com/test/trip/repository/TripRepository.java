package com.test.trip.repository;

import com.test.trip.model.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author jerrySuparman
 */
@Repository
public interface TripRepository extends JpaRepository<Trip, UUID> {
    Page<Trip> findAll(Pageable pageable);
    Page<Trip> findByStatusId(Integer statusId,Pageable pageable);

    @Query(value = "SELECT ts.status, COUNT(t.id) AS total\n" +
            "FROM trip_status ts\n" +
            "LEFT JOIN trip t ON t.status_id = ts.id\n" +
            "     AND TO_CHAR(t.created_at, 'YYYY-MM') = :periode\n" +
            "where ts.id in (2,3)\n" +
            "GROUP BY ts.status\n" +
            "ORDER BY ts.status;",
            nativeQuery = true)
    List<Object[]> countTripsByStatus(String periode);

    @Query(value = "SELECT COUNT(*) AS total_trip\n" +
            "FROM trip\n" +
            "where TO_CHAR(created_at, 'YYYY-MM') = :periode ;",nativeQuery = true)
    Long countTripsMonthly(String periode);

    @Query(value = "select count(t.status_id)\n" +
            "from trip t\n" +
            "where Date(t.created_at) = :periode \n" +
            "and t.status_id =:statusId ;",nativeQuery = true)
    Long trendTotalTripbyDate(LocalDate periode, Integer statusId);

}
