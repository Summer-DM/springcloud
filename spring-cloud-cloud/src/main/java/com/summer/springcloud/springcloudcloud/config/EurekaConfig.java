package com.summerspringcloud.springcloudcloud.config;

import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author Summer_DM
 * @Summary TODO
 * @Version 1.0
 * @Date 2021/8/16 下午 04:48
 **/
@Configuration
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.summer.springcloud.springcloudcloud")
@EnableCircuitBreaker
public class EurekaConfig {
    @Value("${eureka.client.read-timeout}")
    Integer ReadTimeout;//超时时间

    @Value("${eureka.client.connection-timeout}")
    Integer ConnectionTimeout;

    @Bean
    Request.Options requestOptions(ConfigurableEnvironment env){
        int ribbonReadTimeout = env.getProperty("ribbon.ReadTimeout", int.class, ReadTimeout);
        int ribbonConnectionTimeout = env.getProperty("ribbon.ConnectTimeout", int.class, ConnectionTimeout);

        return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
    }
}
