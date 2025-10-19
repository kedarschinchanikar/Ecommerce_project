package com.example.productservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@Entity(name = "products")
public class Product  extends BaseProductModel {
    private  String Title;
    private  String Description;
    private  int  Price;
    private  String ImageUrl;

    @ManyToOne
    private  Category category;
}
