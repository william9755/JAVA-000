package com.geektime;

import com.geektime.component.CallableComponent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author YangMin
 * @time 2020-11-11 13:42
 */
public class FutureTaskDemo {

    public int run() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableComponent());
        new Thread(futureTask).start();
        return futureTask.get().intValue();
    }

}
