package com.example.productservice.Controller;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Product;
import com.example.productservice.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
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
        return null;
    }

    @PatchMapping("/{id}")
    public Product upadteProduct(@PathVariable("id") Long Productid, @RequestBody Product product){
        return null;
    }

    @PutMapping("/{id}")
    public Product ReplaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){

    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> ProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
