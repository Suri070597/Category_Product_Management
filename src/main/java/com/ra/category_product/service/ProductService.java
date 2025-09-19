package com.ra.category_product.service;

import com.ra.category_product.model.entity.Product;
import com.ra.category_product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product update(Integer id, Product newProduct) {
        return repository.findById(id).map(p -> {
            p.setProductName(newProduct.getProductName());
            p.setProductPrice(newProduct.getProductPrice());
            p.setProductStock(newProduct.getProductStock());
            p.setProductStatus(newProduct.isProductStatus());
            p.setCategory(newProduct.getCategory());
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product changeStatus(Integer id, boolean status) {
        return repository.findById(id).map(p -> {
            p.setProductStatus(status);
            return repository.save(p);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        repository.deleteById(id);
    }
}
