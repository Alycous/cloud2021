package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Alycous
 * @Date 2021-10-13 23:58:15
 * @Version 1.0
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentServiceImpl.class)
public interface PaymentService {
    @GetMapping("/sql/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Integer id);
}
