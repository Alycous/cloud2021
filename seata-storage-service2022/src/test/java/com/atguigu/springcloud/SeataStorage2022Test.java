package com.atguigu.springcloud;

import com.atguigu.springcloud.domain.Storage;
import com.atguigu.springcloud.service.StorageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Alycous
 * @Date 2021-10-17 20:10:19
 * @Version 1.0
 */
@SpringBootTest
public class SeataStorage2022Test {
    @Resource
    private StorageService storageService;
    @Test
    public void get(){
        storageService.list().forEach(System.out::println);
    }
}
