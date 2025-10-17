package com.example.productservice.Services;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;

public interface ProductService {


    Product getProductbyId(Long Productid) throws ProductNotFoundException;


}
