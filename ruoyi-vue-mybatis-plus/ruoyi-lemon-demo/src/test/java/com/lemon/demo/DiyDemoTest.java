package com.lemon.demo;

import com.lemon.demo.service.impl.DiyDemoUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Demo测试类，目前是报错的
 *
 * @author 尼古拉斯·柠檬
 * @since 2023/3/15
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DiyDemoTest {
    @Autowired
    private DiyDemoUserServiceImpl userService;

    @Test
    public void myTest() {
        userService.list();
    }
}
