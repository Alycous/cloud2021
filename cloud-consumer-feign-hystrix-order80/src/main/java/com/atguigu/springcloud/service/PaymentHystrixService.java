package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Alycous
 * @Date 2021-10-3 16:06:21
 * @Version 1.0
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-SERVICE",fallback = PaymentHystrixServiceImpl.class)
//@FeignClient(value = "CLOUD-PROVIDER-SERVICE")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String infoOk(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String infoTimeOut(@PathVariable("id") Integer id);
}
