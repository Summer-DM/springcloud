package com.summer.threadpooltaskexecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ThreadPoolTaskExecutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThreadPoolTaskExecutorApplication.class, args);
    }

}
