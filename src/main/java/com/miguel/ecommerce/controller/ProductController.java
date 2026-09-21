package com.miguel.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miguel.ecommerce.model.Product;
import com.miguel.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    //constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping 
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
