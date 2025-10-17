package com.example.productservice.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product  extends BaseProductModel {
    private  String Title;
    private  String Description;
    private  int  Price;
    private  String ImageUrl;
    private  Category category;
}
