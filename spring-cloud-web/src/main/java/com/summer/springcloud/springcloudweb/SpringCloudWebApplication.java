package com.summer.springcloud.springcloudweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@ServletComponentScan
public class SpringCloudWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudWebApplication.class, args);
    }

}
