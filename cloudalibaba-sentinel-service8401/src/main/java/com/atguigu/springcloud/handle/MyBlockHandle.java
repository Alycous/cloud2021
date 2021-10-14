package com.atguigu.springcloud.handle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author Alycous
 * @Date 2021-10-13 22:18:56
 * @Version 1.0
 */

public class MyBlockHandle {

    public static String blockHandleMethod(BlockException e) {
        return "globle!!!!!!!!!!";
    }

    public static String blockHandleMethod2(BlockException e) {
        return "globle!!!!!!!!!!22222";
    }
}
