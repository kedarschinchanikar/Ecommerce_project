package com.example.productservice.Controller;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getProductbyId(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductbyId(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return null;
    }

    @PostMapping()
    public Product CreateProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product upadteProduct(@PathVariable("id") Long Productid, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(Productid,product);
    }

    @PutMapping("/{id}")
    public Product ReplaceProduct(@PathVariable("id") Long productId, @RequestBody Product product) throws ProductNotFoundException {

         return productService.replaceProduct(productId,product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
         productService.deleteProduct(id);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> ProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
