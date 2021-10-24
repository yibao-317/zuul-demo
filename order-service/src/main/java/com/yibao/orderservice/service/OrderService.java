package com.yibao.orderservice.service;

import com.yibao.orderservice.entity.Order;

/**
 * @author liyi
 * @create 2021 -10 -23 -23:58
 */
public interface OrderService {
    // 根据 id 查询订单信息
    Order selectOrderById(Integer id);
}
