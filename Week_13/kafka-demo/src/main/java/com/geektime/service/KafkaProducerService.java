package com.geektime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author YangMin
 * @date 2021/1/13 22:31
 */
@Component
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String msg) {
        kafkaTemplate.sendDefault(msg);
    }


}
