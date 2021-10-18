package com.atguigu.springcloud.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Alycous
 * @Date 2021-10-15 18:51:30
 * @Version 1.0
 */
@Configuration
@MapperScan("com.atguigu.springcloud.dao")
public class MybatisConfig {

}
