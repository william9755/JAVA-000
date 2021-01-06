package com.geektime.config;

import com.geektime.util.RedisLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.SetParams;

@Configuration
public class RedisLockConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxTotal;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${cus.redislock.lock-key}")
    private String lockKey;

    @Value("${cus.redislock.lock-timeout}")
    private long lockTimeout;

    @Value("${cus.redislock.internal-lock-lease-time}")
    private long internalLockLeaseTime;

    @Bean
    public RedisLock createRedisLockUtil() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null);
        RedisLock redisLock = new RedisLock(lockKey,lockTimeout, SetParams.setParams().nx().px(internalLockLeaseTime),jedisPool);
        return redisLock;
    }

}
