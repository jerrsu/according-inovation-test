package com.test.trip;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.YearMonth;

@SpringBootTest
class TripApplicationTests {

//    @Test
//    void contextLoads() {
//    }
public static void main(String[] args) {
    String inputBulan = "2025-03";
    YearMonth yearMonth = YearMonth.parse(inputBulan);
    int jumlahHari = yearMonth.lengthOfMonth(); // jumlah hari dalam bulan tersebut

    for (int i = 1; i <= jumlahHari; i++) {
        LocalDate tanggal = yearMonth.atDay(i);
        System.out.println(tanggal);
    }
}

}
