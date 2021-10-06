package com.atguigu.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alycous
 * @Date 2021-10-3 3:44:03
 * @Version 1.0
 */

@Component
@Slf4j
public class LoadBalanceImpl implements LoadBalance {

    private AtomicInteger atomicInteger;

    public LoadBalanceImpl() {
        atomicInteger = new AtomicInteger(0);
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {
        int index = getIndex(instances.size());
        return instances.get(index);
    }

    /*private int getIndex(int size) {
        for (; ; ) {
            int current = atomicInteger.get();
            int next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                log.info("发起第" + next + "次请求");
                return next % size;
            }
        }
    }*/

    private int getIndex(int size) {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        log.info("发起第{}次请求", next);
        return next % size;
    }
}
