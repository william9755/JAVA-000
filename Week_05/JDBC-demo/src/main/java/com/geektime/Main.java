package com.geektime;

import com.geektime.app.TestApplication;
import com.geektime.util.ConnectionManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangMin
 * @time 2020-11-15 20:57
 */
public class Main {

    // spring 自动注入
    // spring boot 自动配置和 start
    // jdbc 原生增删改查、事务、PrepareStatement、批处理
    // Hikari

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        TestApplication testApplication = (TestApplication) applicationContext.getBean("testApplication");
        testApplication.test();
    }

}
