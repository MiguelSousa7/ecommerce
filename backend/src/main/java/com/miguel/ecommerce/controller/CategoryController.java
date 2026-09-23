package com.miguel.ecommerce.controller;
import com.miguel.ecommerce.dto.category.CategoryResponse;
import com.miguel.ecommerce.model.Category;
import com.miguel.ecommerce.service.CategoryService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    private CategoryService categoryService;

    //constructor
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping 
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }  
}
