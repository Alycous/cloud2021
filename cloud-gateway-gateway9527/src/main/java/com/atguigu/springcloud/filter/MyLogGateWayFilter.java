package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * @author Alycous
 * @Date 2021-10-6 19:26:44
 * @Version 1.0
 */
// Ordered, GlobalFilter
//@Component
@Slf4j
public class MyLogGateWayFilter implements Ordered,GlobalFilter{
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info(LocalDateTime.now() + "开始全局过滤...MyLogGateWayFilter");
        String name = exchange.getRequest().getQueryParams().getFirst("name");
        if (name == null) {
            log.info("用户名为空，无法登录！！！");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}