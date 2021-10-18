package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.domain.Storage;
import com.atguigu.springcloud.mapper.StorageMapper;
import com.atguigu.springcloud.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-17 20:00:29
 * @Version 1.0
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count){
        storageMapper.decrease(productId,count);
    }
}
