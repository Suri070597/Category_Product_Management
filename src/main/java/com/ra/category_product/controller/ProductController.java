package com.ra.category_product.controller;

import com.ra.category_product.model.entity.Product;
import com.ra.category_product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Integer id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @PatchMapping("/{id}/status")
    public Product changeStatus(@PathVariable Integer id, @RequestParam boolean status) {
        return service.changeStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
