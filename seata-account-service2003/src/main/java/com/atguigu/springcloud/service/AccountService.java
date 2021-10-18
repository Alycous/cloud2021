package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.CommonResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Alycous
 * @Date 2021-10-15 18:23:32
 * @Version 1.0
 */
@Mapper
public interface AccountService {

    void decrease(Long userId,BigDecimal money);

}
