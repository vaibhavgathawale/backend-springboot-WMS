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

    // ✅ Return Product list, not just names/// OLD ONe
//    public List<Product> searchProductsOLDAPI(String query) {
//        return repo.findByNameStartingWithIgnoreCase(query);
//    }

    // Enhanced search with multiple strategies
    public List<Product> searchProducts(String query) {
        if (query == null || query.trim().isEmpty()) {
            return getAllProducts();
        }

        String searchQuery = query.trim();

        // For very short queries, use startsWith
        if (searchQuery.length() <= 2) {
            return repo.findByNameStartingWithIgnoreCase(searchQuery);
        }

        // For longer queries, use contains for better results
        return repo.findByNameContainingIgnoreCase(searchQuery);
    }
    // Get products by slug
    public List<Product> getProductsBySlug(String slug) {
        return repo.findBySlugContainingIgnoreCase(slug);
    }
}
