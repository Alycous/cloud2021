package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Alycous
 * @Date 2021-10-17 19:38:16
 * @Version 1.0
 */

@Component
@FeignClient("seata-account-service")
public interface AccountService{

    @PostMapping("/account/decrease")
    public void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
