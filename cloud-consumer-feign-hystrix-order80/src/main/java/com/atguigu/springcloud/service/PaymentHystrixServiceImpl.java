package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Alycous
 * @Date 2021-10-3 19:52:29
 * @Version 1.0
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String infoOk(Integer id) {
        return "implement infoOk";
    }

    @Override
    public String infoTimeOut(Integer id) {
        return "implement infoTimeOut";
    }
}
