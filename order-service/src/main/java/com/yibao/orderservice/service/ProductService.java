package com.yibao.orderservice.service;

import com.yibao.orderservice.entity.Product;
import com.yibao.orderservice.fallback.ProductServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liyi
 * @create 2021 -10 -24 -0:04
 */
@FeignClient(value = "product-service",fallbackFactory = ProductServiceFallbackFactory.class)
public interface ProductService {

    @GetMapping(value = "/product/{id}")
    Product selectProductById(@PathVariable("id") Integer id);
}
