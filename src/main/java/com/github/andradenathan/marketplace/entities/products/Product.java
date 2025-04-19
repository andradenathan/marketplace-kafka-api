package com.github.andradenathan.marketplace.entities.products;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "products")
public class Product {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    private String name;
    private String description;
    private String category;
    private String status;
    private String imageUrl;
    private String price;
    private Boolean isAvailable;

    public Product(String name,
                   String description,
                   String category,
                   String status,
                   String imageUrl,
                   String price,
                   Boolean isAvailable) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.status = status;
        this.imageUrl = imageUrl;
        this.price = price;
        this.isAvailable = isAvailable;
    }
}
