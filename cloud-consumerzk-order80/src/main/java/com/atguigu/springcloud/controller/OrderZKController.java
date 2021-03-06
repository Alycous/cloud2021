package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKController {
    public static final String PAYMENT_URL = "http://cloud-payment-service";
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String zk(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zk", String.class);
        return "order调用结果：" + result;
    }
}
