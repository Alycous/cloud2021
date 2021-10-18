package com.atguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Alycous
 * @Date 2021-10-15 19:52:03
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Storage {
    private Long id;
    private Long productId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
