package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Alycous
 * @Date 2021-10-17 19:24:18
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.atguigu.springcloud.mapper")
public class SeataOrder2011 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrder2011.class, args);
    }
}
