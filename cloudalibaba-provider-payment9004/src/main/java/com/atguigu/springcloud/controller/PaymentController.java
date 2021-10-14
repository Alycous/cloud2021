package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Alycous
 * @Date 2021-10-13 22:52:29
 * @Version 1.0
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static Map<Integer, Payment> map = new HashMap<>();

    static {
        map.put(1, new Payment(1L, "Payment111"));
        map.put(2, new Payment(2L, "Payment111"));
        map.put(3, new Payment(3L, "Payment111"));
    }

    @GetMapping("/sql/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Integer id) {
        Payment payment = map.get(id);
        return new CommonResult<>(200, "(*^_^*)！！！\t" + serverPort, payment);
    }

}
