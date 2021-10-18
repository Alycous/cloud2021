package com.atguigu.springcloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author Alycous
 * @Date 2021-10-15 20:00:04
 * @Version 1.0
 */

public interface StorageService {

    void decrease(Long productId,Integer count);

}
