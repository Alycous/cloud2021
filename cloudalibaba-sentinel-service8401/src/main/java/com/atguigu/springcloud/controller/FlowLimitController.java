package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Alycous
 * @Date 2021-10-12 19:58:28
 * @Version 1.0
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/test/A")
    public String testA(){
        System.out.println(10/0);
        return "testA\t" + UUID.randomUUID().toString();
    }

    @GetMapping("/test/B")
    public String testB(){
        log.info("---testB");
        return "testB\t" + UUID.randomUUID().toString();
    }

    @GetMapping("/test/C")
    public String testC(){
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace();}
        return "testC\t" + UUID.randomUUID().toString();
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "===testHotKey===";
    }
    public String dealTestHotKey(String p1, String p2, Exception e){
        return "===deal_testHotKey===";
    }

    @GetMapping("/test/RT")
    public String testRT(){
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace();}
        return "testRT\t" + UUID.randomUUID().toString();
    }

    @GetMapping("/test/Thread")
    public String testThread(){
        for (int i = 1; i <= 100; i++) {
            new Thread(() -> System.out.println("testThread"), String.valueOf(i)).start();
        }
        return "testThread\t" + UUID.randomUUID().toString();
    }

    @GetMapping("/test/CPU")
    public String testCPU(){
        Instant now = Instant.now();
        LongStream.rangeClosed(1L,100000000000L)
                .parallel()
                .sum();
        Instant end = Instant.now();
        return "testCPU\t" + Duration.between(now, end) +"\t"+ UUID.randomUUID().toString();
    }

    @GetMapping("/test/QPS")
    public String testDPS(){

        log.info("---testQPS");
        return "testQPS\t" + UUID.randomUUID().toString();
    }
    
}
