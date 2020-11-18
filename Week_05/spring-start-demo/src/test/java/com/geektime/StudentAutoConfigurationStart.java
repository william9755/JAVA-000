package com.geektime;

import com.geektime.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author YangMin
 * @time 2020-11-17 09:30
 */
@SpringBootApplication
public class StudentAutoConfigurationStart implements CommandLineRunner {

    @Autowired
    private Student student;

    @Override
    public void run(String... args) throws Exception {
        student.init();
        System.out.println("实体信息为：" + student.toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentAutoConfigurationStart.class,args);
    }

}
