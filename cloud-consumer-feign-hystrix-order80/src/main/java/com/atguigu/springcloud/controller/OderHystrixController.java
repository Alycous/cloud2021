package com.atguigu.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-3 16:09:08
 * @Version 1.0
 *
 * 总结： @DefaultProperties > 实现类 > 定制 > @DefaultProperties
 *
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OderHystrixController {
    @Resource
    PaymentHystrixService service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    //@HystrixCommand
    public String infoOk(@PathVariable("id") Integer id) {
        //int i = 10 / 0;
        return service.infoOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    //@HystrixCommand
    public String infoTimeOut(@PathVariable("id") Integer id) {
        return service.infoTimeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "thread :" + Thread.currentThread().getName() + "\tid:" + id + "80调用超时或者异常！！";
    }

    public String globalFallbackMethod() {
        return "thread :" + Thread.currentThread().getName() + "global80调用超时或者异常！！";
    }
}
