package com.summer.springcloud.kafka;

import com.summer.springcloud.kafka.provider.KafkaSender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
class KafkaApplicationTests {

    @Test
    void contextLoads() {
        //ConfigurableApplicationContext context = SpringApplication.run(SpringbootkafukaApplication.class, args);
        //KafkaSender sender = context.getBean(KafkaSender.class);
        //for (int i = 0; i < 3; i++) {
        //    //调用消息发送类中的消息发送方法
        //    sender.send();
        //    try {
        //        Thread.sleep(3000);
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}

    }

}
