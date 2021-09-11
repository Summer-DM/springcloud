package com.summer.strategymode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StrategyModeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrategyModeApplication.class, args);
    }

}
