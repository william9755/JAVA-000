package com.geektime.util;

public class IdWorker {

    //机器ID
    private long workerId;
    //机房ID
    private long datacenterId;
    //一毫秒内可以生成多少个ID
    private long sequence;
    //时间初始值
    private long twepoch = 1585644268888L;
    //机器id长度
    private long workerIdBits = 5L;
    //机房id长度
    private long datacenterIdBits = 5L;
    //每毫秒内产生的id数
    private long sequenceBits = 12L;
    // 最大机器id
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    // 最大机房id
    private long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    private long workerIdShift = sequenceBits;
    private long datacenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);
    //记录产生时间毫秒数，判断是否是同1毫秒
    private long lastTimestamp = -1L;
    public long getWorkerId(){
        return workerId;
    }
    public long getDatacenterId() {
        return datacenterId;
    }
    public long getTimestamp() {
        return System.currentTimeMillis();
    }

    public IdWorker(long workerId, long datacenterId, long sequence) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("机器 ID 设置错误！");
        }

        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException("机房 ID 设置错误！");
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

    public synchronized long nextId() {
        // 获取当期时间，比较时钟值
        long timestamp = now();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("时钟发生倒退，生成 ID 失败！");
        }

        // 检查同一时刻生成 id 的请求是否超过限制
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        // 记录最近一次生成id的时间戳
        lastTimestamp = timestamp;
        // 按顺序左移时间戳、机房 id、机器 id、并在最后拼接序列号
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << workerIdShift) | sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        // 当某一时间产生的 id 超过限制，则暂停系统直到下一时刻
        long timestamp = now();
        while (timestamp <= lastTimestamp) {
            timestamp = now();
        }
        return timestamp;
    }

    private long now(){
        return System.currentTimeMillis();
    }

}
