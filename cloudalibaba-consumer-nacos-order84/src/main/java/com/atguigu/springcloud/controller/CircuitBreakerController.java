package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-13 23:17:34
 * @Version 1.0
 */
@RestController
@Slf4j
public class CircuitBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serviceURL;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/sql/{id}")
    @SentinelResource(value = "sql",
            blockHandler = "blockHandlerOfSQL",
            fallback = "fallbackOfSQL")
    public CommonResult<Payment> getById(@PathVariable("id") Integer id) {
        CommonResult<Payment> result = restTemplate.getForObject(serviceURL + "/sql/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException /(ㄒoㄒ)/~~!!!");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException /(ㄒoㄒ)/~~");
        }
        return result;
    }

    public CommonResult<Payment> blockHandlerOfSQL(@PathVariable("id") Integer id, BlockException e) {

        Payment payment = new Payment((long) id, null);
        return new CommonResult<Payment>(444, "blockHandlerOfSQL\t" + e.getMessage(), payment);
    }

    public CommonResult<Payment> fallbackOfSQL(@PathVariable("id") Integer id, Throwable e) {
        Payment payment = new Payment((long) id, null);
        return new CommonResult<Payment>(404, "fallbackOfSQL\t" + e.getMessage(), payment);
    }

    //openfeign===============
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/feign/sql/{id}")
    public CommonResult<Payment> feign(@PathVariable("id") Integer id) {
        CommonResult<Payment> result = paymentService.getById(id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException /(ㄒoㄒ)/~~!!!");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException /(ㄒoㄒ)/~~");
        }
        return result;
    }


}
