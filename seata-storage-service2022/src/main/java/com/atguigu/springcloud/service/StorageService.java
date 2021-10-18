package com.atguigu.springcloud.service;

import com.atguigu.springcloud.domain.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * @author Alycous
 * @Date 2021-10-17 20:00:05
 * @Version 1.0
 */

public interface StorageService extends IService<Storage> {
    void decrease(Long productId,Integer count);
}
