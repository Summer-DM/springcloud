package com.summer.threadpooltaskexecutor.controller;

import com.summer.threadpooltaskexecutor.model.Common;
import com.summer.threadpooltaskexecutor.model.Customer;
import com.summer.threadpooltaskexecutor.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author Summer_DM
 * @Summary TODO  定义一个外部访问的接口
 * @Version 1.0
 * @Date 2021/9/2 下午 02:59
 **/
@Controller
@RequestMapping("/thread")
public class ThreadController {
    private static final Logger logger = LoggerFactory.getLogger(ThreadController.class);

    @Autowired
    private AsyncService asyncService;

    /**
     * 提交接口
     * @return
     */
    @RequestMapping("/submit")
    @ResponseBody
    public String submit() throws ExecutionException, InterruptedException {
        logger.info("start submit");
        //调用service层的任务
        CompletableFuture<List<Customer>> completableFuture = asyncService.executeAsync();
        List<Customer> users = completableFuture.get();
        System.out.println(users);
        logger.info("end submit");

        return "success";
    }

    @RequestMapping("/test")
    @ResponseBody
    public void test(){
        long start = System.currentTimeMillis();
        asyncService.findName("张三");
        asyncService.findName("李四");
        asyncService.findName("王五");
        float date = (float) (System.currentTimeMillis() - start) / 1000;
        System.out.println(date);
    }

    @RequestMapping("/getPeo")
    @ResponseBody
    public String getPeo(){
        long start = System.currentTimeMillis();
        Common pro = asyncService.getPro();
        float date = (float) (System.currentTimeMillis() - start) / 1000;
        System.out.println(date);
        System.out.println(pro.toString());
        return "success123";
    }

    @RequestMapping("/getProAsync")
    @ResponseBody
    public String getProAsync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Common> completableFuture = asyncService.getProAsync();
        Common common = completableFuture.get();
        float date = (float) (System.currentTimeMillis() - start) / 1000;
        System.out.println(date);
        System.out.println(common.toString());
        return "success456";
    }

}
