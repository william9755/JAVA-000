package com.geektime.week1;

import java.lang.reflect.Method;

/**
 *
 * @author YangMin
 * @date 2020-10-19 22:03:41
 */
public class Main {

    public static void main(String[] args) {
        loadXlass();
    }

    private static void loadXlass() {
        HelloXlassLoader classLoader = new HelloXlassLoader();
        Class clazz = classLoader.findClass("Hello");
        if(clazz != null) {
            try {
                Object obj = clazz.newInstance();
                Method testMethod = clazz.getMethod("hello");
                testMethod.invoke(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("xlass file load failed!");
        }
    }

}
