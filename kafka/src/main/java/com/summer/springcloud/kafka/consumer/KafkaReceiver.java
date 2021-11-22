package com.summer.springcloud.kafka.consumer;

import com.summer.springcloud.kafka.provider.KafkaSender;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author Summer_DM
 * @Summary TODO  kafka消费者
 * @Version 1.0
 * @Date 2021/11/22 下午 04:28
 **/
@Component
public class KafkaReceiver {
    private static final Logger log = LoggerFactory.getLogger(KafkaReceiver.class);

    @KafkaListener(topics = {"message"})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("----------------- record =" + record);
            log.info("------------------ message =" + message);
        }
    }

}
