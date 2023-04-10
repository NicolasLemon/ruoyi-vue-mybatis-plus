package com.lemon.demo;

import com.lemon.demo.domain.User;
import com.lemon.demo.service.impl.UserServiceImpl;
//import com.ruoyi.RuoYiApplication;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Demo用户测试类
 * 此处注释掉是因为用循环引入依赖了，
 * 若想临时测试需要，则可以把pom中的依赖给加上
 *
 * @author 尼古拉斯·柠檬
 * @since 2023/3/15
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = RuoYiApplication.class)
//@ComponentScan(basePackages = {"com.ruoyi", "com.lemon"})
@Slf4j
@RequiredArgsConstructor
@SuppressWarnings("all")
public class UserTest {
    private final UserServiceImpl userService;

    @Test
    public void myTest() {
        List<User> userList = userService.list();
        log.info("查询结果集：" + userList);
    }
}
