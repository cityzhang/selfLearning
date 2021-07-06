package com.example.selfProject.mbg.mapper;

import com.example.selfProject.mbg.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<User> findAllUser();

    int insertUser(User user);

    User checkUser(User user);
}
