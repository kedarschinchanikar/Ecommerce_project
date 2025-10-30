package com.example.productservice.Services;

import com.example.productservice.DTOs.FakeStoreProductDTO;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements  ProductService {

    private RestTemplate restTemplate;
    private RedisTemplate<String, Object> redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    private Product ConvertToProduct(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();

        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImageUrl(fakeStoreProductDTO.getImageURl());
        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product getProductbyId(Long Productid) throws ProductNotFoundException {
        Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT_"+Productid);

        if(product != null) {
            return product;
        }

       FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + Productid,
                FakeStoreProductDTO.class);

       if (fakeStoreProductDTO == null) {
           throw new ProductNotFoundException("Product with Id: "+ Productid + " does not exist.");
       }

       product = ConvertToProduct(fakeStoreProductDTO);

       redisTemplate.opsForHash().put("PRODUCTS","PRODUCT_" + Productid, product);

        return product;
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products/",
                FakeStoreProductDTO[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS) {
            products.add(ConvertToProduct(fakeStoreProductDTO));
        }
        return new PageImpl<>(products);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
