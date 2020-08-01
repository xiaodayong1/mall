package com.xiaodayong.mall.controller;

import com.xiaodayong.mall.service.UmsMemberService;
import com.xiaodyaong.mall.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName : UmsMemberController  //类名
 * @Description : 根据电话号码获取验证码的接口和校验验证码的接口  //描述
 * @Author : Xiaodayong  //作者
 * @Date: 2020-07-31 13:51  //时间
 */
@RestController
@Api(tags = "UmsMemberController" ,value = "会员登陆注册管理")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ApiOperation("获取验证码")
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone){
        return umsMemberService.generateAuthCode(telephone);
    }

    @RequestMapping(value = "/verifyAuthCode",method = RequestMethod.POST)
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                       @RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }

}
