package com.example.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long Id;
    private String Title;
    private String Description;
    private int Price;
    private String category;
    private String ImageURl;
}
