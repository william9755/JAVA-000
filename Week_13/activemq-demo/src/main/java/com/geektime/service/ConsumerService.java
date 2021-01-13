package com.geektime.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author YangMin
 * @date 2021/1/12 13:45
 */
@Component
public class ConsumerService {

    @JmsListener(destination = "${spring.activemq.queue-name}",containerFactory = "queueListener")
    public void readQueueMsg(String msg) {
        System.out.println("queue msg: " + msg);
    }

    @JmsListener(destination = "${spring.activemq.topic-name}",containerFactory = "topicListener")
    public void readTopicMsg(String msg) {
        System.out.println("topic msg: " + msg);
    }
}
