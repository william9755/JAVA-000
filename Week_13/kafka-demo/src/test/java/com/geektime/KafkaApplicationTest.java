package com.geektime;

import com.geektime.service.KafkaProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangMin
 * @date 2021/1/13 22:32
 */
@SpringBootTest
public class KafkaApplicationTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    void testTopic() {
        for(int i = 0;i < 100;i++) {
            kafkaProducerService.send("No. " + i + " Msg");
        }
    }

}
