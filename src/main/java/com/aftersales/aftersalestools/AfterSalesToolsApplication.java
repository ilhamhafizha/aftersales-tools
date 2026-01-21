package com.aftersales.aftersalestools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AfterSalesToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfterSalesToolsApplication.class, args);
    }

}
