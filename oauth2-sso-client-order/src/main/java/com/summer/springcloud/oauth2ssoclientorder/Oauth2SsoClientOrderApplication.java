package com.summer.springcloud.oauth2ssoclientorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Oauth2SsoClientOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2SsoClientOrderApplication.class, args);
    }

}
