package com.kwin._4springioc.controller;

import com.kwin._4springioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired // 如果当前类只有一个构造器，此注解可以省略
    public UserController(UserService userService) {
        this.userService = userService;
    }
}
