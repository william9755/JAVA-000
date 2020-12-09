package com.geektime;

import com.geektime.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangMin
 * @date 2020/12/8 21:23
 */
@SpringBootTest
public class ShardingSphereXaDemoApplicationTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        orderService.addOrder();
    }
}
