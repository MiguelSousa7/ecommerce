package com.miguel.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miguel.ecommerce.model.Product;
import com.miguel.ecommerce.repository.ProductRepository;

@Service 
public class ProductService {
    private ProductRepository productRepository;

    //constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
