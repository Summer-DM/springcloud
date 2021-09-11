package com.summer.threadpooltaskexecutor;

import com.summer.threadpooltaskexecutor.service.AsyncService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadPoolTaskExecutorApplicationTests {
    @Autowired
    private AsyncService asyncService;
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        asyncService.findName("张三");
        asyncService.findName("李四");
        asyncService.findName("王五");
        float date = (float) (System.currentTimeMillis() - start) / 1000;
        System.out.println(date);
    }

}
