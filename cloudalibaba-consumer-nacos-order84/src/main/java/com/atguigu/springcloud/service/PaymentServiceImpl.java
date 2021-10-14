package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author Alycous
 * @Date 2021-10-14 0:01:00
 * @Version 1.0
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> getById(Integer id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment((long)id, "errorSerial......"));
    }
}
