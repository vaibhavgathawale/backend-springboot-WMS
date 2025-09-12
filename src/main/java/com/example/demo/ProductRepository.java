package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {


    // Custom query to find words starting with input
    List<Product> findByNameStartingWithIgnoreCase(String name);

    // For more flexible search
    List<Product> findByNameContainingIgnoreCase(String name);

    // Search by slug
    List<Product> findBySlugContainingIgnoreCase(String slug);

    // Search products with minimum length
    @Query("SELECT p FROM Product p WHERE LENGTH(:query) >= 2 AND LOWER(p.name) LIKE LOWER(CONCAT(:query, '%'))")
    List<Product> searchWithMinLength(@Param("query") String query);

    // New methods needed
    List<Product> findByIsNewTrue();
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    List<Product> findByPriceGreaterThanEqual(double minPrice);
    List<Product> findByPriceLessThanEqual(double maxPrice);
    // Search with multiple criteria
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(p.slug) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Product> searchByNameOrSlug(@Param("query") String query);
}
