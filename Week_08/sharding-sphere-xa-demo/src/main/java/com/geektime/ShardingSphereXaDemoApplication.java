package com.geektime;

import com.geektime.config.TransactionConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author YangMin
 * @date 2020/12/8 20:36
 */
@SpringBootApplication
@Import(TransactionConfiguration.class)
public class ShardingSphereXaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereXaDemoApplication.class,args);
    }

}
