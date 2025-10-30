package com.example.productservice.Services;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product getProductbyId(Long Productid) throws ProductNotFoundException;

    Page<Product> getAllProducts(int pageNumber, int pageSize);

    Product createProduct(Product product);

    Product replaceProduct (Long id, Product product) throws ProductNotFoundException;

    void deleteProduct(Long id) throws ProductNotFoundException;

    Product updateProduct(Long id, Product product) throws ProductNotFoundException;
}
