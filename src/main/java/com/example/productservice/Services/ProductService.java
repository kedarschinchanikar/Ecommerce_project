package com.example.productservice.Services;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;

import java.util.List;

public interface ProductService {

    Product getProductbyId(Long Productid) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product);
}
