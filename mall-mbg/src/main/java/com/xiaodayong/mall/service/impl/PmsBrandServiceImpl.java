package com.xiaodayong.mall.service.impl;/**
 * @Author : xiao
 * @Date : 2020/7/21 11:58
 */

import com.github.pagehelper.PageHelper;
import com.xiaodayong.mall.mapper.PmsBrandMapper;
import com.xiaodayong.mall.model.PmsBrand;
import com.xiaodayong.mall.model.PmsBrandExample;
import com.xiaodayong.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: my-mall
 * @description: 品牌管理service实现类
 * @author: Mr.Xiao
 * @create: 2020-07-21 11:58
 **/
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    @Resource
    PmsBrandMapper pmsBrandMapper;


    @Override
    public List<PmsBrand> getAllList() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int creatBrand(PmsBrand brand) {
        return pmsBrandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(long id, PmsBrand brand) {
        brand.setId(id);

        return pmsBrandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(long id) {

        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }


}
