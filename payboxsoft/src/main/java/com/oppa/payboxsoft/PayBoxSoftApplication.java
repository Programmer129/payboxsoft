package com.oppa.payboxsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PayBoxSoftApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayBoxSoftApplication.class, args);
    }

}
