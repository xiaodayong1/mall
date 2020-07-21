package com.xiaodayong.mall.controller;/**
 * @Author : xiao
 * @Date : 2020/7/21 11:33
 */

import com.xiaodayong.mall.common.CommonResult;
import com.xiaodayong.mall.mapper.PmsBrandMapper;
import com.xiaodayong.mall.model.PmsBrand;
import com.xiaodayong.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: my-mall
 * @description: 品牌管理controller
 * @author: Mr.Xiao
 * @create: 2020-07-21 11:33
 **/
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    @RequestMapping(value = "listAll" ,method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(pmsBrandService.getAllList());
    }



}
