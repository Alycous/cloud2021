package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.domain.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Alycous
 * @Date 2021-10-17 19:35:52
 * @Version 1.0
 */

public interface AccountMapper extends BaseMapper<Account> {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
