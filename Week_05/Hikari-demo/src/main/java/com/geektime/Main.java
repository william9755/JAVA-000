package com.geektime;

import com.geektime.app.TestApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author YangMin
 * @time 2020-11-15 20:57
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        TestApplication testApplication = (TestApplication) applicationContext.getBean("testApplication");
        testApplication.test();
    }

}
