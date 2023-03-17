package com.lemon.demo.controller;


import com.lemon.demo.service.impl.DiyUserServiceImpl;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 自定义Demo 前端控制器
 * </p>
 *
 * @author Nicolas·Lemon
 * @since 2023/03/16
 */
@RestController
@RequestMapping("/demo/diy")
public class DiyUserDemoController extends BaseController {
    @Autowired
    private DiyUserServiceImpl userService;

    /**
     * 查询所有用户
     *
     * @return 查询到的用户结果集
     */
    @GetMapping("/users")
    public AjaxResult listDemoUsers() {
        return AjaxResult.success(userService.list());
    }

    /**
     * 通过用户id查询用户
     *
     * @param userId 用户id
     * @return 通过用户id查询到的用户
     */
    @GetMapping("/user/{id}")
    public AjaxResult getUserById(@PathVariable("id") String userId) {
        return AjaxResult.success(userService.getById(userId));
    }
}
