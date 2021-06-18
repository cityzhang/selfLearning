package com.example.selfProject.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户")
public class User {
    @ApiModelProperty(value = "student id")
    Integer id;
    String name;
}
