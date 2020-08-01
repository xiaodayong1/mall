package com.xiaodayong.mall.service;

import com.xiaodyaong.mall.api.CommonResult;

public interface UmsMemberService {
    /**
    * @Param [telephone] //参数
    * @description   获取验证码 //描述
    * @author HTB //作者
    * @date 2020/7/31 16:44 //时间
    * @return com.xiaodyaong.mall.api.CommonResult  //返回值
    * @throws   //异常
    */
    CommonResult generateAuthCode(String telephone);

    CommonResult verifyAuthCode(String telephone, String authCode);
}
