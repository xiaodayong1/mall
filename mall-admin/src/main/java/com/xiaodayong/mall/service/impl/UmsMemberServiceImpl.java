package com.xiaodayong.mall.service.impl;

import com.xiaodayong.mall.service.RedisService;
import com.xiaodayong.mall.service.UmsMemberService;
import com.xiaodyaong.mall.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @ClassName : UmsMemberServiceImpl  //类名
 * @Description : 会员管理service实现类  //描述
 * @Author : Xiaodayong  //作者
 * @Date: 2020-07-31 16:33  //时间
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Resource
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {

        StringBuilder sb=new StringBuilder();
        Random random=new Random();
        for (int i=0;i<6;i++){
            sb.append(random.nextInt(10));
        }
        String key=REDIS_KEY_PREFIX_AUTH_CODE+telephone;
        redisService.set(key,sb.toString());
        redisService.expire(key,AUTH_CODE_EXPIRE_SECONDS);

        return CommonResult.success(sb.toString(),"获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        String key=REDIS_KEY_PREFIX_AUTH_CODE+telephone;
        if (!StringUtils.isEmpty(authCode)){
            String realAuthCode = redisService.get(key).toString();
            boolean equals = authCode.equals(realAuthCode);
            if (equals){
                return CommonResult.success(null,"验证成功");
            }else {
                return CommonResult.failed("验证码错误");
            }
        }else {
            return CommonResult.failed("验证码不能为空");
        }
    }
}
