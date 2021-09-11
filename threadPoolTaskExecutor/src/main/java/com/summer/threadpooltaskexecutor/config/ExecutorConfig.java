package com.summer.threadpooltaskexecutor.config;

import com.summer.threadpooltaskexecutor.handler.VisiableThreadPoolTaskExecutor;
import com.summer.threadpooltaskexecutor.model.TaskThreadPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Summer_DM
 * @Summary TODO  线程池配置类
 * @Version 1.0
 * @Date 2021/9/2 下午 03:04
 **/
@Configuration
@EnableAsync
public class ExecutorConfig {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Autowired
    private TaskThreadPoolConfig taskThreadPoolConfig;

    @Bean
    public Executor asyncServiceExecutor() {
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
        //核心线程数：线程池创建时候初始化的线程数
        executor.setCorePoolSize(taskThreadPoolConfig.getCorePoolSize());
        //配置最大线程数：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(taskThreadPoolConfig.getMaxPoolSize());
        //配置队列大小：用来缓冲执行任务的队列
        executor.setQueueCapacity(taskThreadPoolConfig.getQueueCapacity());
        //允许线程的空闲时间-秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
        executor.setKeepAliveSeconds(taskThreadPoolConfig.getKeepAliveSeconds());
        //配置线程池中的线程的名称前缀：设置好了之后可以方便我们定位处理任务所在的线程池
        executor.setThreadNamePrefix("async-service-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        //noinspection AlibabaSwitchStatement
        switch (taskThreadPoolConfig.getRejectedExecutionHandler()){
            case "AbortPolicy":
                executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
                break;
            case "CallerRunsPolicy":
                executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
                break;
            case "DiscardPolicy":
                executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
                break;
            case "DiscardOldestPolicy":
                executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
                break;
        }
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //执行初始化
        executor.initialize();
        return executor;
    }

}
