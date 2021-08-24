package com.summer.springcloud.springclouduser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@ServletComponentScan
@EnableEurekaClient
public class SpringCloudUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudUserApplication.class, args);
    }

}
