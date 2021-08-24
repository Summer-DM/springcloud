package com.summer.springcloud.oauth2ssoauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Oauth2SsoAuthServerApplication {

    public static void main(String[] args) {
        System.out.println("服务起动，并且本地配置了redis");
        SpringApplication.run(Oauth2SsoAuthServerApplication.class, args);
    }

}
