package com.geektime;

import com.geektime.component.InvokeComponent;

import java.util.concurrent.CountDownLatch;

/**
 * @author YangMin
 * @time 2020-11-11 14:04
 */
public class CountDownLatchDemo {

    private int result;

    public int run() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ThreadComponent threadComponent = new ThreadComponent();
        threadComponent.setCountDownLatch(countDownLatch);
        new Thread(threadComponent).start();
        countDownLatch.await();
        return result;
    }

    class ThreadComponent implements Runnable {

        private CountDownLatch countDownLatch;

        public void setCountDownLatch(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            result = InvokeComponent.invoke();
            countDownLatch.countDown();
        }
    }

}
