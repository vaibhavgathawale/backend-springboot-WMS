package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // ✅ Return Product list, not just names
    public List<Product> searchProducts(String query) {
        return repo.findByNameStartingWithIgnoreCase(query);
    }
}
