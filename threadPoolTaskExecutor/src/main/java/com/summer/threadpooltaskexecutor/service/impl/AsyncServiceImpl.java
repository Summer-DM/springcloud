package com.summer.threadpooltaskexecutor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.summer.threadpooltaskexecutor.mapper.CustomMapper;
import com.summer.threadpooltaskexecutor.mapper.UserMapper;
import com.summer.threadpooltaskexecutor.model.Common;
import com.summer.threadpooltaskexecutor.model.Customer;
import com.summer.threadpooltaskexecutor.model.ScUser;
import com.summer.threadpooltaskexecutor.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Author Summer_DM
 * @Summary TODO  实现service，处理业务逻辑
 * @Version 1.0
 * @Date 2021/9/2 下午 02:55
 **/
@Service
public class AsyncServiceImpl extends ServiceImpl<CustomMapper, Customer> implements AsyncService  {

    private static final Logger log = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Autowired
    private CustomMapper customMapper;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl userService;
    /**
     * 执行异步线程
     *因为不能立即返回，所以需要将返回值
     * @return
     */
    @Override
    @Async("asyncServiceExecutor")
    public CompletableFuture<List<Customer>> executeAsync() {
        log.info("start executeAsync");
        System.out.println("\n\n----------------------------------------------");
        System.out.println("当前运行的线程名称：" + Thread.currentThread().getName() + "正在处理请求");
        System.out.println("---- ------------------------------------------");
        List<Customer> users = new ArrayList<>();
        try {
            //写我们的业务逻辑
            Customer user = new Customer();
            user.setId("1");
            user.setName("孙猴子");
            user.setAdress("北京市昌平区天通苑北街道");
            user.setAge(18);
            users.add(user);
            customMapper.insert(user);
            int i = 1 / 0;
            //return CompletableFuture.completedFuture(users);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        log.info("end executeAsync");
        return CompletableFuture.completedFuture(users);
    }

    @Override
    @Async("asyncServiceExecutor")
    public String findName(String name) {
        System.out.println(name + "调用了");

        return name;
    }

    @Override
    public Customer getCustomers(String id) {
        QueryWrapper<Customer> wrapper = new QueryWrapper();
        wrapper.eq("id",id);
        Customer customer = customMapper.selectById(id);
        return customer;
    }

    @Override
    //@Async("asyncServiceExecutor")
    public Common getPro() {
        Common common = new Common();
        Customer customers = getCustomers("1434697454627848194");
        ScUser users = userService.getUsers("1427158549582163969");
        common.setCustomer(customers);
        common.setScUser(users);
        return common;
    }

    @Override
    public CompletableFuture<Common> getProAsync(){
        log.info("start executeAsync");
        System.out.println("\n\n----------------------------------------------");
        System.out.println("当前运行的线程名称：" + Thread.currentThread().getName() + "正在处理请求");
        System.out.println("---- ------------------------------------------");
        Common common = new Common();
        Customer customers = getCustomers("1434697454627848194");
        ScUser users = userService.getUsers("1427158549582163969");
        common.setCustomer(customers);
        common.setScUser(users);
        return CompletableFuture.completedFuture(common);
    }
}
