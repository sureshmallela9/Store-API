package com.store.controller;

import com.store.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "API for managing products")
public class ProductController {

    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1L, "Laptop", "High-end gaming laptop", 999.99));
        products.add(new Product(2L, "Mouse", "Wireless mouse", 29.99));
        products.add(new Product(3L, "Keyboard", "Mechanical keyboard", 149.99));
    }

    @GetMapping
    @Operation(summary = "Get all products", description = "Retrieve a list of all products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get product by ID", description = "Retrieve a specific product by its ID")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new product", description = "Add a new product to the store")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        long newId = products.stream()
                .mapToLong(Product::getId)
                .max()
                .orElse(0L) + 1;
        product.setId(newId);
        products.add(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Update an existing product")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(product -> {
                    product.setName(updatedProduct.getName());
                    product.setDescription(updatedProduct.getDescription());
                    product.setPrice(updatedProduct.getPrice());
                    return ResponseEntity.ok(product);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Remove a product from the store")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean removed = products.removeIf(p -> p.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

