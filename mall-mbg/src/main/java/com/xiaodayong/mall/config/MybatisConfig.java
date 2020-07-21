package com.xiaodayong.mall.config;/**
 * @Author : xiao
 * @Date : 2020/7/21 11:31
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: my-mall
 * @description: mybatis配置类
 * @author: Mr.Xiao
 * @create: 2020-07-21 11:31
 **/
@Configuration
@MapperScan("com.xiaodayong.mall.mapper")
public class MybatisConfig {
}
