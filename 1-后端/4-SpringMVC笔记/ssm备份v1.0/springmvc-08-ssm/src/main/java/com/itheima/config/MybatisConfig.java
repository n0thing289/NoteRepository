package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;


import javax.sql.DataSource;

public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        //还需要两配置
        //1. dataSource
        bean.setDataSource(dataSource);//spring根据类型自动装配到这里
        //2. 扫描pojo包
        bean.setTypeAliasesPackage("com.itheima.pojo");
        return bean;
    }

    //映射器
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("com.itheima.mapper");//扫描这个包下的接口,mybatis自动生成实现类
        return msc;
    }

    //自动驼峰映射?

    //开事务?
}
