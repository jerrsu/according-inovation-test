package com.test.trip.service;

import com.test.trip.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

/**
 * @author jerrySuparman
 */

@Service
public class DashboardService {
    @Autowired
    private TripRepository tripRepository;

    public Map<String, Long> getCountTripsByStatus(String periode) {
        List<Object[]> result = tripRepository.countTripsByStatus(periode);
        Map<String, Long> map = new HashMap<>();
        for (Object[] row : result) {
            String status = (String) row[0];
            Long count = ((Number) row[1]).longValue();
            map.put(status, count);
        }
        return map;
    }

    public Map<String, Long> getCountTripsMonthly(String periode) {
        Long result = tripRepository.countTripsMonthly(periode);
        Map<String, Long> map = new HashMap<>();
        map.put("total", result);
        return map;
    }

    public Object getTrendTrip(String periode,Integer statusId) {
        List<String> listDate = this.listDate(periode);
        HashMap hashMap = new HashMap();
        return listDate.stream().map(map -> {
            String date = map;
            hashMap.put("date", date);
            hashMap.put("count", tripRepository.trendTotalTripbyDate(LocalDate.parse(date),statusId));
            return hashMap;
        });
    }

    public List<String> listDate(String periode) {
        YearMonth yearMonth = YearMonth.parse(periode);
        int sumOfDay = yearMonth.lengthOfMonth();
        List<String> tanggalList = new ArrayList<>();
        for (int i = 1; i <= sumOfDay; i++) {
            LocalDate tanggal = yearMonth.atDay(i);
            tanggalList.add(tanggal.toString());
        }
        return tanggalList;
    }
}
