package com.lemon.demo;

import com.lemon.demo.domain.DiyUser;
import com.lemon.demo.service.impl.DiyUserServiceImpl;
import com.ruoyi.RuoYiApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Demo用户测试类
 *
 * @author 尼古拉斯·柠檬
 * @since 2023/3/15
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuoYiApplication.class)
@ComponentScan(basePackages = {"com.ruoyi", "com.lemon"})
@Slf4j
public class DiyUserTest {
    @Autowired
    private DiyUserServiceImpl userService;

    @Test
    public void myTest() {
        List<DiyUser> userList = userService.list();
        log.info("查询结果集：" + userList);
    }
}
