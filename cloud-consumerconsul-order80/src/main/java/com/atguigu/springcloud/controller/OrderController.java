package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMETN_URL = "http://consul-payment-service";
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public Object info(){
        String res = restTemplate.getForObject(PAYMETN_URL + "/payment/consul", String.class);
        log.info("consul result:" + res);
        return res;
    }
}
