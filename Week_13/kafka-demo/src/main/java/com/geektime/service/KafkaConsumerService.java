package com.geektime.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author YangMin
 * @date 2021/1/13 22:31
 */
@Component
public class KafkaConsumerService {

    @KafkaListener(topics = {"${spring.kafka.producer.default-topic}"})
    public void readKafkaTopic(List<?> list){
        list.stream().forEach(v -> System.out.println("topic msg: " + v));
    }

}
