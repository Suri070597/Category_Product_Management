package com.ra.category_product.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name", length = 100, unique = true, nullable = false)
    private String CategoryName;
    @Column(name = "category_status")
    private boolean CategoryStatus;
}
