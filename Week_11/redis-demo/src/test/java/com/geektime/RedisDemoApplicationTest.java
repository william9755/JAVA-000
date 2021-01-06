package com.geektime;

import com.geektime.service.RedisLockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisDemoApplicationTest {

    @Autowired
    private RedisLockService redisLockService;

    @Test
    public void test() {
        try {
            redisLockService.testLock();
            redisLockService.testIncr();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
