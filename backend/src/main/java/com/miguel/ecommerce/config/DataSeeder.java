package com.miguel.ecommerce.config;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.miguel.ecommerce.dto.product.ProductSeed;
import com.miguel.ecommerce.model.Category;
import com.miguel.ecommerce.model.Product;
import com.miguel.ecommerce.repository.CategoryRepository;
import com.miguel.ecommerce.repository.ProductRepository;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Component 
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
     private final ObjectMapper objectMapper;
    
    //constructor
    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.objectMapper = objectMapper;
    }

    @Override 
    public void run(String... args) throws Exception {
        //clear all existing data in product and category
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //seed category table
        InputStream categoriesData = getClass().getResourceAsStream("/seed/categories.json");
        
        List<Category> categories = objectMapper.readValue(
                categoriesData,
                new TypeReference<List<Category>>() {}
        );

        if (categoryRepository.count() == 0) {
            categoryRepository.saveAll(categories);
        }


        //seed product table
        InputStream productsData = getClass().getResourceAsStream("/seed/products.json");
        
        List<ProductSeed> productData = objectMapper.readValue(
                productsData,
                new TypeReference<List<ProductSeed>>() {}
        );

        List<Product> products = new ArrayList<>();
        
        for (ProductSeed data : productData) {
            Category category = categoryRepository.findByName(data.getCategory());

            Product product = new Product();
            product.setName(data.getName());
            product.setDescription(data.getDescription());
            product.setImageUrl(data.getImageUrl());
            product.setPrice(data.getPrice());
            product.setCategory(category);

            products.add(product);
        }

        if (productRepository.count() == 0) {
            productRepository.saveAll(products);
        }
    }
}
