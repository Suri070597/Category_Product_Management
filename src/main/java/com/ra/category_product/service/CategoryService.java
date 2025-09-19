package com.ra.category_product.service;

import com.ra.category_product.model.entity.Category;
import com.ra.category_product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public Category update(Integer id, Category newCategory) {
        return repository.findById(id).map(c -> {
            c.setCategoryName(newCategory.getCategoryName());
            c.setCategoryStatus(newCategory.isCategoryStatus());
            return repository.save(c);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category changeStatus(Integer id, boolean status) {
        return repository.findById(id).map(c -> {
            c.setCategoryStatus(status);
            return repository.save(c);
        }).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        repository.deleteById(id);
    }
}