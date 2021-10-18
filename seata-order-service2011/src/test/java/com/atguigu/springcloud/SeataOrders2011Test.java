package com.atguigu.springcloud;

import com.atguigu.springcloud.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-17 20:01:43
 * @Version 1.0
 */
@SpringBootTest
public class SeataOrders2011Test {
    @Resource
    OrderService orderService;
    @Test
    public void get(){
        orderService.list().forEach(System.out::println);
    }
}
