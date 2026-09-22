package com.miguel.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miguel.ecommerce.dto.category.CategoryResponse;
import com.miguel.ecommerce.dto.product.ProductRequest;
import com.miguel.ecommerce.dto.product.ProductResponse;
import com.miguel.ecommerce.model.Category;
import com.miguel.ecommerce.model.Product;
import com.miguel.ecommerce.repository.CategoryRepository;
import com.miguel.ecommerce.repository.ProductRepository;

@Service 
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    //constructor
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    //GET ALL
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
    }

    //GET BY CATEGORY
    public List<ProductResponse> getProductByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // POST
    public ProductResponse createProduct(ProductRequest request) {

        Category category = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow();

        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setImageUrl(request.getImageUrl());
        product.setPrice(request.getPrice());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        return toResponse(savedProduct);
    }
    
    // dto mapper
    private ProductResponse toResponse(Product product) {

        ProductResponse response = new ProductResponse();

        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setImageUrl(product.getImageUrl());
        response.setPrice(product.getPrice());

        CategoryResponse category = new CategoryResponse();
        category.setId(product.getCategory().getId());
        category.setName(product.getCategory().getName());

        response.setCategory(category);

        return response;
    }
}