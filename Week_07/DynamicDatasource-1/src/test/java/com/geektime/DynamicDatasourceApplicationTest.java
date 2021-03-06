package com.geektime;

import com.geektime.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author YangMin
 * @date 2020/12/6 22:09
 */
@SpringBootTest
public class DynamicDatasourceApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        userService.addUser();
        List<Map<String,Object>> list = userService.getAllUser();
        userService.deleteAllUser();
    }
}
