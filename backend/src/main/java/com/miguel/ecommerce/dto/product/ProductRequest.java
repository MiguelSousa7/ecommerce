package com.miguel.ecommerce.dto.product;

import lombok.Data;

@Data 
public class ProductRequest {

    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private Long categoryId;
}