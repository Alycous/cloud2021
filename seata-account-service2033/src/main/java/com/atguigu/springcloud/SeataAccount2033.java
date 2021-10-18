package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Alycous
 * @Date 2021-10-17 19:23:49
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.atguigu.springcloud.mapper")
public class SeataAccount2033 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccount2033.class, args);
    }
}
