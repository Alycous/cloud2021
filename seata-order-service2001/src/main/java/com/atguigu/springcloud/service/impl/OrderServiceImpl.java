package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.OrderDao;
import com.atguigu.springcloud.domain.Order;
import com.atguigu.springcloud.service.AccountService;
import com.atguigu.springcloud.service.OrderService;
import com.atguigu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-15 18:20:40
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-seata-order",rollbackFor = Exception.class)
    public void create(Order order) {
        //1 创建订单
        log.info("订单开始创建------");
        orderDao.create(order);
        //2 库存减一
        log.info("库存减少{}个------",order.getCount());
        storageService.decrease(order.getProductId(),order.getCount());
        //3 账户扣费
        log.info("账户减少{}元------",order.getMoney());
        accountService.decrease(order.getUserId(),order.getMoney());
        //4 订单更新
        orderDao.update(order.getUserId(), 0);
        log.info("订单创建完成O(∩_∩)O！！------");
    }
}
