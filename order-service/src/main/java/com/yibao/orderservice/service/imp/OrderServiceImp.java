package com.yibao.orderservice.service.imp;

import com.yibao.orderservice.entity.Order;
import com.yibao.orderservice.service.OrderService;
import com.yibao.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author liyi
 * @create 2021 -10 -23 -23:59
 */
@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private ProductService productService;

    @Override
    public Order selectOrderById(Integer id) {
        return new Order(1, "1号订单",
                "1号订单地址",
                33.33,
                Arrays.asList(productService.selectProductById(id)));
    }
}
