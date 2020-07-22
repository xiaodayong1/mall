# mall

mall
├── mall-common -- 工具类及通用代码
├── mall-mbg -- MyBatisGenerator生成的数据库操作代码
├── mall-security -- SpringSecurity封装公用模块
├── mall-admin -- 后台商城管理系统接口
├── mall-search -- 基于Elasticsearch的商品搜索系统
├── mall-portal -- 前台商城系统接口
└── mall-demo -- 框架搭建时的测试代码
### 7-21
 整合mybatis逆向工程生成资源
   1.配置generator.properties 逆向工程配置文件
   2.Generator逆向工程主函数
   3.CommonGenerator逆向工程注释生成器

### 7-22
 整合swagger2生成接口文档，修改generator的注释生成类集成swagger，使model带注释
