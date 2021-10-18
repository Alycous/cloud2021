package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-17 21:01:00
 * @Version 1.0
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public void decrease(Long productId,Integer count){
        storageService.decrease(productId, count);
    }
}
