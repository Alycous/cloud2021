package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Alycous
 * @Date 2021-10-6 18:23:58
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GatwayMain9572 {
    public static void main(String[] args) {
        SpringApplication.run(GatwayMain9572.class, args);
    }
}
