package com.example.selfProject.service;

import com.example.selfProject.mbg.mapper.TestMapper;
import com.example.selfProject.mbg.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    TestMapper testMapper;

    public void addUser(User user){
        testMapper.insertUser(user);
    }
}
