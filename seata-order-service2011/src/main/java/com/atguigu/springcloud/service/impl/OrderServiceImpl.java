package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.domain.Orders;
import com.atguigu.springcloud.mapper.OrderMapper;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-17 19:57:14
 * @Version 1.0
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders> implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-seata-order",rollbackFor = Exception.class)
    public void create(Orders orders){
        //orders.setStatus(0);
        //订单增加
        orderMapper.create(orders);
        //orderMapper.insert(orders);
        //库存减少
        storageService.decrease(orders.getProductId(),orders.getCount());
        //账户扣除
        accountService.decrease(orders.getUserId(),orders.getMoney());
        //订单更新
        orderMapper.updateStatus(orders.getUserId(), 0);
    }
}
