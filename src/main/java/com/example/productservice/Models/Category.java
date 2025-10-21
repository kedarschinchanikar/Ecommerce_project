package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "categories")
public class Category extends BaseProductModel {
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
