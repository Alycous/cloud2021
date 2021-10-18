package com.atguigu.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Alycous
 * @Date 2021-10-17 20:00:05
 * @Version 1.0
 */
@FeignClient(value = "seata-storage-service")
//@FeignClient(url = "http://localhost:2022")
@Component
public interface StorageService {
    @PostMapping("/storage/decrease")
    public void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
