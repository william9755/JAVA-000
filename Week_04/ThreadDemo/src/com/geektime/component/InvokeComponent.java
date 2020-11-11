package com.geektime.component;

/**
 * @author YangMin
 * @time 2020-11-11 13:39
 */
public class InvokeComponent {

    public static int invoke() {

        return fibo(33);
    }

    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }

}
