package com.example.selfProject.controller;

import com.example.selfProject.mbg.model.User;
import com.example.selfProject.security.JwtUserDetailsService;
import com.example.selfProject.service.UserService;
import com.example.selfProject.utils.JwtTokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Api(tags = "Users", description = "用户")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    JwtTokenUtils jwtTokenUtils;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpServletRequest request) {
        User userCheck = userService.checkUser(user);
        if (userCheck == null) {
            return "账号或密码错误";
        }
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(userCheck.getName());
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtils.generateToken(userDetails);
        return token;
    }

    @PreAuthorize("hasAnyRole('U')")
    @PostMapping("haha")
    public String haha(Principal principal) {
        System.out.println(principal.getName());
        return "haha:";
    }

    @PostMapping("/testAgain")
    public void test(){
        System.out.println("test");
    }
}
