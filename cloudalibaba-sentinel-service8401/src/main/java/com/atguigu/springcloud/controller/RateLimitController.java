package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.handle.MyBlockHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Alycous
 * @Date 2021-10-13 21:57:38
 * @Version 1.0
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult<Payment> byResource(){
        return new CommonResult<>(200, "success!!!", new Payment(666L, UUID.randomUUID().toString()));
    }
    public CommonResult<Payment> handleException(BlockException e){
        return new CommonResult<>(444, "/(ㄒoㄒ)/~~!!!");
    }

    @GetMapping("/myBlockHandler")
    @SentinelResource(value = "myBlockHandler",
            blockHandlerClass = {MyBlockHandle.class},
            blockHandler = "blockHandleMethod2")
    public String myBlockHandler(){
        return "(*^_^*)";
    }


}
