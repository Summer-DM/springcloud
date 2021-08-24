package com.summer.springcloud.springcloudcommon;

import com.summer.springcloud.springcloudcommon.fileModel.FileProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@ServletComponentScan
@EnableEurekaClient
@EnableConfigurationProperties({
        FileProperty.class
})
public class SpringCloudCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudCommonApplication.class, args);
    }
}
