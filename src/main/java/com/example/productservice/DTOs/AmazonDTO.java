package com.example.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.servlet.ServletRegistration;

@Getter
@Setter
public class AmazonDTO {
    private Double price;
    private String category;
    private String imageURl;
    private String productName;
}
