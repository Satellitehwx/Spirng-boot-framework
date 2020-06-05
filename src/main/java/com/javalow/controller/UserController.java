package com.javalow.controller;

import com.javalow.domain.User;
import com.javalow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 用户接口控制器
 * @author: huweixing
 * @ClassName: UserController
 * @Date: 2020-06-05
 * @Time: 10:51
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @GetMapping("/findUserById")
    public String findUserById(@RequestParam Integer userId) {
        User user = userService.getUserById(userId);
        return user.toString();
    }

}
