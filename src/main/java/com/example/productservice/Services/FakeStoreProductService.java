package com.example.productservice.Services;

import com.example.productservice.DTOs.FakeStoreProductDTO;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Category;
import com.example.productservice.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements  ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
       FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + Productid,
                FakeStoreProductDTO.class);

       if (fakeStoreProductDTO == null) {
           throw new ProductNotFoundException("Product with Id: "+ Productid + " does not exist.");
       }
        return ConvertToProduct(fakeStoreProductDTO);
    }


}
