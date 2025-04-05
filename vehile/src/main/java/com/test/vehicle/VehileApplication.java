package com.test.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class VehileApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehileApplication.class, args);
    }

}
