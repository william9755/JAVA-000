package com.geektime.service;

import com.geektime.util.IdWorker;
import com.geektime.util.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class RedisLockService {

    @Autowired
    private RedisLock redisLock;

    @Autowired
    private IdWorker idWorker;

    public void testLock() throws InterruptedException {
        int clientCount = 100;
        CountDownLatch countDownLatch = new CountDownLatch(clientCount);
        ExecutorService executorService = Executors.newFixedThreadPool(clientCount);
        for (int i = 0; i < clientCount; i++) {
            executorService.execute(() -> {
                String id = String.valueOf(idWorker.nextId());
                try {
                    while (!redisLock.lock(id)) {
                    }
                    System.out.printf("%d --> lock: %s\n",Thread.currentThread().getId(),id);
                } finally {
                    redisLock.unlock(id);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
    }

    public void testIncr() throws InterruptedException {
        int clientCount = 10;
        int requestCount = 100;
        CountDownLatch countDownLatch = new CountDownLatch(clientCount);
        ExecutorService executorService = Executors.newFixedThreadPool(clientCount);
        for (int i = 0; i < requestCount; i++) {
            executorService.execute(() -> {
                String threadId = String.valueOf(Thread.currentThread().getId());
                Jedis jedis = redisLock.getJedis();
                jedis.incr(threadId);
                System.out.printf("%s: %s\n",threadId,jedis.get(threadId));
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
    }

}
