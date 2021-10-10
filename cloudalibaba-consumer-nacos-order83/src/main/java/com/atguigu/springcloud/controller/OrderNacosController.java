package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-9 18:03:51
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Value("${service-url.nacos-user-service}")
    public String serviceUrl;

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String get(@PathVariable("id") Long id){
        return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
    }

}
