package com.miguel.ecommerce.dto.product;

import lombok.Data;

@Data 
public class ProductSeed {
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    private String category;
}