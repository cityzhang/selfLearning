package com.example.selfProject.service.impl;

import com.example.selfProject.common.CommonResult;
import com.example.selfProject.properties.RedisProperties;
import com.example.selfProject.service.RedisService;
import com.example.selfProject.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    RedisProperties redisProperties;
    @Autowired
    RedisService redisService;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        redisService.set(redisProperties.getREDIS_KEY_PREFIX_AUTH_CODE()+telephone,sb.toString(),redisProperties.getAUTH_CODE_EXPIRE_SECONDS());
        return CommonResult.success(sb.toString(),"获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(redisProperties.getREDIS_KEY_PREFIX_AUTH_CODE() + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
