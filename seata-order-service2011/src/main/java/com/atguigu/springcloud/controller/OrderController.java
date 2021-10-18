package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.domain.Orders;
import com.atguigu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-17 21:25:53
 * @Version 1.0
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public String create(Orders orders){
        orderService.create(orders);
        return "success!!!";
    }
}
