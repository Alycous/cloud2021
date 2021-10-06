package com.atguigu.springcloud;

import org.junit.jupiter.api.*;

import java.time.ZonedDateTime;

/**
 * @author Alycous
 * @Date 2021-10-6 18:58:29
 * @Version 1.0
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
    @BeforeAll
    static void test2(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}
