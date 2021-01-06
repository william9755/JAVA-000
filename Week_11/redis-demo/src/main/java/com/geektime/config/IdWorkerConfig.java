package com.geektime.config;

import com.geektime.util.IdWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IdWorkerConfig {

    @Value("${cus.idworker.worker-id}")
    private long workerId;

    @Value("${cus.idworker.datacenter-id}")
    private long datacenterId;

    @Value("${cus.idworker.sequence}")
    private long sequence;

    @Bean
    public IdWorker createIdWorker() {
        return new IdWorker(workerId,datacenterId,sequence);
    }
}
