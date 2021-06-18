package com.example.selfProject.controller;

import com.example.selfProject.common.CommonResult;
import com.example.selfProject.service.ElasticTestService;
import com.example.selfProject.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "验证码服务")
@RestController
@RequestMapping("/ums")
public class UmsController {
    @Autowired
    UmsMemberService umsMemberService;
    @Autowired
    ElasticTestService elasticTestService;


    @ApiOperation(value = "获取验证码")
    @GetMapping()
    public CommonResult getUms(String telephone) {
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation(value = "验证码审核")
    @PostMapping()
    public CommonResult checkUms(String telephone, String verifyAuthCode) {
        return umsMemberService.verifyAuthCode(telephone, verifyAuthCode);
    }

    @ApiOperation(value = "ES添加test记录")
    @PostMapping("/addEs")
    public void addEs(){
        elasticTestService.addTest();;
    }
}
