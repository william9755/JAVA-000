package com.geektime.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

public class RedisLock {

    private String lockKey;
    private long lockTimeout;
    private SetParams params;
    private JedisPool jedisPool;

    public Jedis getJedis() {
        return jedisPool.getResource();
    }

    public RedisLock(String lockKey, long lockTimeout, SetParams params, JedisPool jedisPool) {
        this.lockKey = lockKey;
        this.lockTimeout = lockTimeout;
        this.params = params;
        this.jedisPool = jedisPool;
    }

    public boolean lock(String id) {
        Jedis jedis = jedisPool.getResource();
        Long start = System.currentTimeMillis();
        try {

            while (true) {
                String lock = jedis.set(lockKey, id, params);
                if ("OK".equals(lock)) {
                    return true;
                }

                long l = System.currentTimeMillis() - start;
                if (l >= lockTimeout) {
                    return false;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        } finally {
            jedis.close();
        }
    }

    public boolean unlock(String id) {
        Jedis jedis = jedisPool.getResource();
        try {
            String keyValue = jedis.get(lockKey);
            if (id.equals(keyValue)) {
                return jedis.del(lockKey) == 1l;
            }
            return false;
        } finally {
            jedis.close();
        }
    }

}
