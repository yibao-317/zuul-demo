package com.yibao.productservice.controller;

import com.yibao.productservice.entity.Product;
import com.yibao.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyi
 * @create 2021 -10 -23 -23:46
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product selectProductById(@PathVariable("id") Integer id){
        return productService.selectProductById(id);
    }




}
