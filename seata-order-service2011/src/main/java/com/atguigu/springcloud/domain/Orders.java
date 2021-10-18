package com.atguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Alycous
 * @Date 2021-10-17 19:27:13
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;

}
