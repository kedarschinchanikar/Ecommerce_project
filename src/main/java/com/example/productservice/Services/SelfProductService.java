package com.example.productservice.Services;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;
import com.example.productservice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductbyId(Long ProductId) throws ProductNotFoundException {
        Optional<Product> optionalproduct = productRepository.findById(ProductId);

        if(optionalproduct.isEmpty()){
            throw new ProductNotFoundException("prduct with id: " + ProductId + " does not exist");
        }
        return optionalproduct.get();
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
