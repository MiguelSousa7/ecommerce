package com.miguel.ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.miguel.ecommerce.dto.product.ProductRequest;
import com.miguel.ecommerce.dto.product.ProductResponse;
import com.miguel.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    //constructor
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping 
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductResponse> getProductByCategory(@PathVariable Long categoryId) {
        return productService.getProductByCategory(categoryId);
    }

    @PostMapping 
    public ProductResponse createProduct(
        @RequestBody ProductRequest request
    ) {
        return productService.createProduct(request);
    }
}
