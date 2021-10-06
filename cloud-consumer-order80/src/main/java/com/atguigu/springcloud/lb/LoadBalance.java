package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Alycous
 * @Date 2021-10-3 3:43:39
 * @Version 1.0
 */

public interface LoadBalance {

    ServiceInstance getInstance(List<ServiceInstance> instances);
}
