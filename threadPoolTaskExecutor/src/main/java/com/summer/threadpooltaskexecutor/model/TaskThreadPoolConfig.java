package com.summer.threadpooltaskexecutor.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Summer_DM
 * @Summary TODO  线程配置类
 * @Version 1.0
 * @Date 2021/9/2 下午 05:06
 **/
@ConfigurationProperties(prefix = "task.pool")
@Component
@Data
public class TaskThreadPoolConfig {
    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

    private String rejectedExecutionHandler;

}
