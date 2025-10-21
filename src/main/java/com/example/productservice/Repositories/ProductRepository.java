package com.example.productservice.Repositories;

import com.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long ProductId);

    @Override
     Product save(Product product);

    @Override
    void deleteById(Long aLong);
}
