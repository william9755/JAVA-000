package com.geektime.datasource.routing;

/**
 * @author YangMin
 * @date 2020/12/6 21:23
 */
public class DynamicDatasourceThreadLocal {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void setDataSource(String name) {
        THREAD_LOCAL.set(name);
    }

    public static String getDataSource() {
        return THREAD_LOCAL.get();
    }

    public static void removeDataSource() {
        THREAD_LOCAL.remove();
    }

}
