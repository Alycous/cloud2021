package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Account;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * @author Alycous
 * @Date 2021-10-17 19:38:16
 * @Version 1.0
 */

public interface AccountService extends IService<Account> {

    void decrease(Long userId, BigDecimal money);
}
