package com.geektime.app;

import com.geektime.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author YangMin
 * @time 2020-11-16 20:00
 */
@Component
public class TestApplication {

    @Autowired
    private IUserService userService;

    public void test() {
        userService.test();
        userService.testBatch();
    }
}
