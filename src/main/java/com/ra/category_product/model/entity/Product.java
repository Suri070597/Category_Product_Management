package com.ra.category_product.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name", length = 100, unique = true, nullable = false)
    private String ProductName;

    @Column(name = "product_price", nullable = false)
    private double ProductPrice;

    @Column(name = "product_stock", nullable = false)
    private int ProductStock;

    @Column(name = "product_status", nullable = false)
    private boolean ProductStatus;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}