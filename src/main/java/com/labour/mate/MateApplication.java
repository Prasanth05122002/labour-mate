package com.labour.mate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.labour.mate")
public class MateApplication {

    public static void main(String[] args) {
        SpringApplication.run(MateApplication.class, args);
    }

}