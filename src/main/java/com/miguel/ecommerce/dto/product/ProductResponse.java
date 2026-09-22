package com.miguel.ecommerce.dto.product;

import com.miguel.ecommerce.dto.category.CategoryResponse;

import lombok.Data;

@Data 
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private CategoryResponse category;
}
