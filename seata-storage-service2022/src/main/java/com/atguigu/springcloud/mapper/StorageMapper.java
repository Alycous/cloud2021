package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.domain.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Alycous
 * @Date 2021-10-17 19:59:32
 * @Version 1.0
 */

public interface StorageMapper extends BaseMapper<Storage> {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
