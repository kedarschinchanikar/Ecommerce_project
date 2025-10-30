package com.example.productservice.Services;


import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
