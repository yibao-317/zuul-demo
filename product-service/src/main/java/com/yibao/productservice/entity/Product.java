package com.yibao.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liyi
 * @create 2021 -10 -23 -23:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String productName;
    private Integer productNum;
    private Double productPrice;
}
