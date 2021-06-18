package com.example.selfProject.controller;

import com.example.selfProject.mbg.model.User;
import com.example.selfProject.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Users",description = "用户")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
