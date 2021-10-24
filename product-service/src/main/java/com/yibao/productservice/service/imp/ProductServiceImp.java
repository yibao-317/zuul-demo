package com.yibao.productservice.service.imp;

import com.yibao.productservice.entity.Product;
import com.yibao.productservice.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author liyi
 * @create 2021 -10 -23 -23:48
 */
@Service
public class ProductServiceImp implements ProductService {
    @Override
    public Product selectProductById(Integer id) {
        return new Product(id, "商品111", 1, 999.99);
    }
}
