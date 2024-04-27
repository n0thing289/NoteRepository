package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.itheima.service"})
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {
    /**
     * spring 核心配置文件
     */

    /**
     * 事务处理三步
     * 1. 开启注解式事务驱动
     *      @EnableTransactionManagement
     * 2. 配置平台事务管理器
     *      在JdbcConfig中配置
     * 3. 添加事务
     *      在业务层接口@Transactional
     */
}
