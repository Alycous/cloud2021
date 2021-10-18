package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.domain.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Alycous
 * @Date 2021-10-17 19:58:09
 * @Version 1.0
 */

public interface OrderMapper extends BaseMapper<Orders> {
    void updateStatus(@Param("userId") Long userId, @Param("status") int status);

    void create(Orders orders);
}
