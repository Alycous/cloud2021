package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-3 14:55:40
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Resource
    PaymentService paymentService;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String infoOk(@PathVariable("id") Integer id){
        String result =  paymentService.infoOk(id);
        log.info("infoOk ： " + result);
        return result + "\tport: "+ serverPort;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String infoTimeOut(@PathVariable("id") Integer id){
        String result =  paymentService.infoTimeOut(id);
        log.info("timeout ： " + result);
        return result + "\tport: "+ serverPort;
    }
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }
}
