package com.store.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product Information")
public class Product {

    @Schema(description = "Product ID", example = "1")
    private Long id;

    @Schema(description = "Product Name", example = "Laptop")
    private String name;

    @Schema(description = "Product Description", example = "High-end gaming laptop")
    private String description;

    @Schema(description = "Product Price", example = "999.99")
    private Double price;

    public Product() {}

    public Product(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

