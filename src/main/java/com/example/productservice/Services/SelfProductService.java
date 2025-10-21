package com.example.productservice.Services;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import com.example.productservice.Repositories.CategoryRepository;
import com.example.productservice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    private final AbstractHandlerMethodAdapter abstractHandlerMethodAdapter;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository, AbstractHandlerMethodAdapter abstractHandlerMethodAdapter) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.abstractHandlerMethodAdapter = abstractHandlerMethodAdapter;
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
        Category category = product.getCategory();
        Optional<Category> optionalcategory = categoryRepository.findByName(category.getName());

        if(optionalcategory.isEmpty()){
           category= categoryRepository.save(category);
        }
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()){
           throw new ProductNotFoundException("product with id: "+ id +" does not exist");
        }
        Product productFromDB = productOptional.get();

        productFromDB.setPrice(product.getPrice());
        productFromDB.setDescription(product.getDescription());
        productFromDB.setTitle(product.getTitle());
        productFromDB.setImageUrl(product.getImageUrl());
        productFromDB.setCategory(product.getCategory());

        Category category = product.getCategory();

        if(category.getId() == null){
            category = categoryRepository.save(category);
        }

        productFromDB.setCategory(category);

        return productRepository.save(productFromDB);
    }

    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException{
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("product with id: "+ id +" does not exist");
        }
        Product productFromDB = productOptional.get();

        productFromDB.setPrice(product.getPrice());
        productFromDB.setDescription(product.getDescription());
        productFromDB.setImageUrl(product.getImageUrl());
        productFromDB.setCategory(product.getCategory());

        Category category = product.getCategory();

        if(category.getId() == null){
            category = categoryRepository.save(category);
        }

        productFromDB.setCategory(category);

        return productRepository.save(productFromDB);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("product with id: "+ id +" does not exist");
        }

        productRepository.deleteById(id);
    }
}
