package com.geektime.component;

import java.util.concurrent.Callable;

/**
 * @author YangMin
 * @time 2020-11-11 13:44
 */
public class CallableComponent implements Callable<Integer> {

    @Override
    public Integer call() {
        return InvokeComponent.invoke();
    }

}
