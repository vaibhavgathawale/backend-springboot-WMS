package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name= "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slug;
    private String name;
    private double price;

    @ElementCollection
    private List<String> sizes;

    @Transient // This prevents it from being stored in database
    private String selectedSize;

    private String image;
    private boolean isNew;

    // Add this field for cart functionality (should NOT be persisted)
    @Transient // This prevents it from being stored in database
    private Integer quantity = 0;


}
