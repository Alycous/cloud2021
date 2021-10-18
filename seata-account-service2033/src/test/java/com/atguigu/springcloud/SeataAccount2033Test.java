package com.atguigu.springcloud;

import com.atguigu.springcloud.domain.Account;
import com.atguigu.springcloud.service.AccountService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-17 19:44:25
 * @Version 1.0
 */
@SpringBootTest
public class SeataAccount2033Test {
    @Resource
    private AccountService accountService;
    @Test
    public void testService(){
        Page<Account> page = accountService.page(new Page<>(1, 5));
        System.out.println(page.getRecords());
    }
}
