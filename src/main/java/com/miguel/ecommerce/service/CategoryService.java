package com.miguel.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miguel.ecommerce.dto.category.CategoryResponse;
import com.miguel.ecommerce.dto.product.ProductResponse;
import com.miguel.ecommerce.model.Category;
import com.miguel.ecommerce.model.Product;
import com.miguel.ecommerce.repository.CategoryRepository;

@Service 
public class CategoryService {
    private CategoryRepository categoryRepository;

    //constructor
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }
    
    // dto mapper
    private CategoryResponse toResponse(Category category) {
        CategoryResponse response = new CategoryResponse();

        response.setId(category.getId());
        response.setName(category.getName());

        return response;
    }
}
