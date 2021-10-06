package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 111
 */
@RestController
@Slf4j

public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    DiscoveryClient discoveryClient;
    @Resource
    PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("操作返回的结果:{}", result);
        if (result > 0) {
            return new CommonResult<>(200, "数据添加成功！serverPort: " + serverPort, result);
        } else {
            return new CommonResult<>(400, "数据添加失败！");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("操作返回的结果:{}", payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功！serverPort: " + serverPort, payment);
        } else {
            return new CommonResult<>(400, "查询失败！没有此id：" + id);
        }
    }

    @GetMapping(value = "/payment/discover")
    public Object discover() {
        List<String> services = discoveryClient.getServices();
        services.forEach(log::info);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(x -> log.info(x.getServiceId() + "\t" + x.getHost() + "\t" + x.getPort() + "\t" + x.getUri()));
        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String feignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
