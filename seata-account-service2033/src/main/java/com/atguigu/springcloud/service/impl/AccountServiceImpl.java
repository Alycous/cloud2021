package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.domain.Account;
import com.atguigu.springcloud.mapper.AccountMapper;
import com.atguigu.springcloud.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Alycous
 * @Date 2021-10-17 19:39:05
 * @Version 1.0
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountMapper.decrease(userId, money);
        //int a = 1/0;
    }
}
