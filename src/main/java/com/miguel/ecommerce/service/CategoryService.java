package com.miguel.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.miguel.ecommerce.model.Category;
import com.miguel.ecommerce.repository.CategoryRepository;

@Service 
public class CategoryService {
    private CategoryRepository categoryRepository;

    //constructor
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
