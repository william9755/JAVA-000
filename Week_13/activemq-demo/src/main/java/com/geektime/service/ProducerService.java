package com.geektime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author YangMin
 * @date 2021/1/12 13:42
 */
@Component
public class ProducerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void sendQueue(String msg) {
        jmsMessagingTemplate.convertAndSend(queue, msg);
    }

    public void sendTopic(String msg) {
        jmsMessagingTemplate.convertAndSend(topic, msg);
    }

}
