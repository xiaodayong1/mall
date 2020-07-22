package com.xiaodayong.mall.service;

import com.xiaodayong.mall.model.PmsBrand;

import java.util.List;

/**
 * @Author : xiao
 * @Date : 2020/7/21 11:57*/


public interface PmsBrandService {
    List<PmsBrand> getAllList();

    int creatBrand(PmsBrand brand);

    int updateBrand(long id, PmsBrand brand);

    int deleteBrand(long id);

    List<PmsBrand> listBrand(Integer pageNum, Integer pageSize);

    PmsBrand getBrand(long id);
}
