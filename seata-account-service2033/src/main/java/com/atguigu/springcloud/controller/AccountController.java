package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Alycous
 * @Date 2021-10-17 21:15:53
 * @Version 1.0
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;
    
    @PostMapping("/account/decrease")
    public void decrease(Long userId, BigDecimal money){
        accountService.decrease(userId, money);
    }
}
