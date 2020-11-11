package com.geektime;

import java.util.concurrent.ExecutionException;

/**
 * @author YangMin
 * @time 2020-11-11 13:36
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureDemo completableFutureDemo = new CompletableFutureDemo();
        System.out.println("CompletableFuture 执行结果为：" + completableFutureDemo.run());

        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        System.out.println("CountDownLatch 执行结果为：" + countDownLatchDemo.run());

        FutureDemo futureDemo = new FutureDemo();
        System.out.println("Future 执行结果为：" + futureDemo.run());

        FutureTaskDemo futureTaskDemo = new FutureTaskDemo();
        System.out.println("FutureTask 执行结果为：" + futureTaskDemo.run());

    }

}
