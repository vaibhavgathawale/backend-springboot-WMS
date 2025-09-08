package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")  // 👈 allow Angular
public class ProductController {

    private final ProductService service;

    private final ProductRepository repository;

    public ProductController(ProductService service, ProductRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    // ✅ Now returns Product objects
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam("q") String query) {
        return service.searchProducts(query);
    }

    // ✅ Single product details by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
