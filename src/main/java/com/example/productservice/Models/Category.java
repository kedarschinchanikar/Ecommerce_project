package com.example.productservice.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseProductModel {
    @Column(unique = true)
    private String name;

    @OneToMany( mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
