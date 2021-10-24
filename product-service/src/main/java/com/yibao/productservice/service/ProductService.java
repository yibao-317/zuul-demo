package com.yibao.productservice.service;

import com.yibao.productservice.entity.Product;

/**
 * @author liyi
 * @create 2021 -10 -23 -23:47
 */
public interface ProductService {
    // 根据 id 查询商品
    Product selectProductById(Integer id);
}
