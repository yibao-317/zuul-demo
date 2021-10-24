package com.yibao.orderservice.fallback;

import com.yibao.orderservice.entity.Product;
import com.yibao.orderservice.service.ProductService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author liyi
 * @create 2021 -10 -24 -0:21
 */
@Component
public class ProductServiceFallbackFactory implements FallbackFactory<ProductService> {
    @Override
    public ProductService create(Throwable cause) {
        return new ProductService() {
            @Override
            public Product selectProductById(Integer id) {
                return new Product(id,
                        "托底数据",
                        2, 11.11);
            }
        };
    }
}
