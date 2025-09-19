package com.ra.category_product.controller;

import com.ra.category_product.model.entity.Category;
import com.ra.category_product.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Integer id, @RequestBody Category category) {
        return service.update(id, category);
    }

    @PatchMapping("/{id}/status")
    public Category changeStatus(@PathVariable Integer id, @RequestParam boolean status) {
        return service.changeStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
}