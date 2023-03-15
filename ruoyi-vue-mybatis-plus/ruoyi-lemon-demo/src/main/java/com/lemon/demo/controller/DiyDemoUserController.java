package com.lemon.demo.controller;


import com.lemon.demo.service.impl.DiyDemoUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Nicolas·Lemon
 * @since 2023/03/15
 */
@RestController
@RequestMapping("/demo/diy")
public class DiyDemoUserController {
    @Autowired
    private DiyDemoUserServiceImpl userService;

    @GetMapping("/user/list")
    public void a() {
        System.out.println(userService);
        userService.list();
    }
}

