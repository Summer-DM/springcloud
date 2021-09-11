package com.summer.threadpooltaskexecutor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.summer.threadpooltaskexecutor.model.Common;
import com.summer.threadpooltaskexecutor.model.Customer;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Author Summer_DM
 * @Summary TODO  执行线程接口
 * @Version 1.0
 * @Date 2021/9/2 下午 02:53
 **/
public interface AsyncService extends IService<Customer> {

    /**
     * 执行异步线程
     */
    CompletableFuture<List<Customer>> executeAsync();

    String findName(String name);

    Customer getCustomers(String id);

    Common getPro();

    CompletableFuture<Common> getProAsync();
}
