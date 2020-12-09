package com.geektime;

import com.geektime.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YangMin
 * @date 2020/12/9 14:28
 */
@SpringBootTest
public class ShardingSphereTableDemoApplicationTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test() {
        orderService.addOrder();
        orderService.getOrder();
        orderService.updateOrder();
        orderService.deleteOrder();
    }
}
