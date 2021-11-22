package com.summer.springcloud.kafka.provider;

import com.summer.springcloud.springcloudweb.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @Author Summer_DM
 * @Summary TODO  kafka生产者
 * @Version 1.0
 * @Date 2021/11/22 下午 04:24
 **/
@Component
public class KafkaSender {
    private static final Logger log = LoggerFactory.getLogger(KafkaSender.class);
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    //发送消息方法
    public void send() {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", message.toString());
        kafkaTemplate.send("message", message.toString());
    }

}
