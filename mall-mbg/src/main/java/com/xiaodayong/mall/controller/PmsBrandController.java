package com.xiaodayong.mall.controller;/**
 * @Author : xiao
 * @Date : 2020/7/21 11:33
 */

import com.xiaodayong.mall.common.CommonPage;
import com.xiaodayong.mall.common.CommonResult;
import com.xiaodayong.mall.mapper.PmsBrandMapper;
import com.xiaodayong.mall.model.PmsBrand;
import com.xiaodayong.mall.service.PmsBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: my-mall
 * @description: 品牌管理controller
 * @author: Mr.Xiao
 * @create: 2020-07-21 11:33
 **/
@Controller
@RequestMapping("/brand")
@Slf4j
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;


    /**
     * 功能描述: <br>
     * 〈获取品牌列表〉
     * @Param: []
            * @Return: com.xiaodayong.mall.common.CommonResult<java.util.List<com.xiaodayong.mall.model.PmsBrand>>
            * @Author: xiaodayong
            * @Date: 2020/7/21 14:58
     */
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(pmsBrandService.getAllList());
    }

    /**
     * 功能描述: <br>
     * 〈创建品牌〉
     * @Param: [brand]
            * @Return: com.xiaodayong.mall.common.CommonResult
            * @Author: xiaodayong
            * @Date: 2020/7/21 15:06
     */
    @RequestMapping(value = "/creat",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult creatBrand(@RequestBody PmsBrand brand){

        CommonResult commonResult;

        int count=pmsBrandService.creatBrand(brand);
        if (count==1){
            commonResult=CommonResult.success(brand);
            log.info("brand创建成功",brand);
        }else {
            commonResult=CommonResult.failed("创建品牌失败");
            log.info("brand创建失败",brand);
        }
        return commonResult;
    }

    /**
     * 功能描述: <br>
     * 〈修改品牌信息〉
     * @Param: [id, brand]
            * @Return: com.xiaodayong.mall.common.CommonResult
            * @Author: xiaodayong
            * @Date: 2020/7/21 16:44
     */
    @ResponseBody
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public CommonResult updateBrand(@PathVariable("id") long id,@RequestBody PmsBrand brand){

        CommonResult commandResult;
        int count=pmsBrandService.updateBrand(id,brand);

        if (count == 1){
            commandResult=CommonResult.success(brand);
            log.info("修改成功",brand);
        }else {
            commandResult = CommonResult.failed("修改失败");
            log.info("品牌信息修改失败");
        }
        return commandResult;
    }

    /**
     * 功能描述: <br>
     * 〈根据id删除品牌〉
     * @Param: [id]
            * @Return: com.xiaodayong.mall.common.CommonResult
            * @Author: xiaodayong
            * @Date: 2020/7/21 17:07
     */
    @RequestMapping(value = "/delete/{id}" ,method = RequestMethod.GET)
    @ResponseBody
    public CommonResult  deleteBrand(@PathVariable("id") long id){
        CommonResult commandResult;
        int count=pmsBrandService.deleteBrand(id);

        if (count == 1){
            commandResult=CommonResult.success("删除成功");
            log.info("deleteBrand success :id={}");
        }else {
            commandResult = CommonResult.failed("删除成功");
            log.info("deleteBrand failed :id={}"+id);
        }
        return commandResult;
    }

    /**
     * 功能描述: <br>
     * 〈分页查询〉
     * @Param: [pageNum, pageSize]
            * @Return: com.xiaodayong.mall.common.CommonResult<com.xiaodayong.mall.common.CommonPage<com.xiaodayong.mall.model.PmsBrand>>
            * @Author: xiaodayong
            * @Date: 2020/7/21 17:28
     */
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum",defaultValue ="1") Integer pageNum,
                                                          @RequestParam(value = "pageSize",defaultValue = "3") Integer pageSize){
        List<PmsBrand> pmsBrandList=pmsBrandService.listBrand(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(pmsBrandList));
    }

    @RequestMapping(value = "/{id}",method =  RequestMethod.GET)
    public CommonResult<PmsBrand> getBrand(@PathVariable("id") long id){
        PmsBrand pmsBrand=pmsBrandService.getBrand(id);
        return CommonResult.success(pmsBrand);
    }

}
