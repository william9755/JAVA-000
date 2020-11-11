package com.geektime;

import com.geektime.component.CallableComponent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author YangMin
 * @time 2020-11-11 13:50
 */
public class CompletableFutureDemo {

    public int run() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf = CompletableFuture
                .supplyAsync(() -> new CallableComponent().call());
        while (!cf.isDone()) {
            // wait
        }
        return cf.get().intValue();
    }
}
