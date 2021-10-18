package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Alycous
 * @Date 2021-10-17 19:56:35
 * @Version 1.0
 */

public interface OrderService extends IService<Orders> {
    void create(Orders orders);
}
