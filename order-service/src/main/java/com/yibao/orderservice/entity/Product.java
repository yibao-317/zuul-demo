package com.yibao.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author liyi
 * @create 2021 -10 -24 -0:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private Integer id;
    private String productName;
    private Integer productNum;
    private Double productPrice;
}
