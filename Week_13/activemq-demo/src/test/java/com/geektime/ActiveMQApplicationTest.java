package com.geektime;

import com.geektime.service.ConsumerService;
import com.geektime.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangMin
 * @date 2021/1/12 13:50
 */
@SpringBootTest
public class ActiveMQApplicationTest {

    @Autowired
    private ProducerService producerService;

    @Test
    public void testQueue() {
        for(int i = 0;i < 100;i++) {
            producerService.sendQueue("No. " + i + " Msg");
        }
    }

    @Test
    public void testTopic() {
        for(int i = 0;i < 100;i++) {
            producerService.sendTopic("No. " + i + " Msg");
        }
    }
}
