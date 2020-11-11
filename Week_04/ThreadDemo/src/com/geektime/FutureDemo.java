package com.geektime;

import com.geektime.component.CallableComponent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

/**
 * @author YangMin
 * @time 2020-11-11 13:48
 */
public class FutureDemo {

    public int run() throws ExecutionException, InterruptedException {
        Future<Integer> future = Executors.newCachedThreadPool()
                .submit(() -> new CallableComponent().call());
        while (!future.isDone()) {
            // wait
        }

        return future.get().intValue();
    }

}
