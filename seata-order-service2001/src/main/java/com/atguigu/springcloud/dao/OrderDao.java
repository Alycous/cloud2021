package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Alycous
 * @Date 2021-10-15 18:00:44
 * @Version 1.0
 */
@Mapper
public interface OrderDao {

    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
