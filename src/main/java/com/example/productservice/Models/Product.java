package com.example.productservice.Models;

import jakarta.persistence.*;
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

    @ManyToOne (cascade = {CascadeType.REMOVE})
    @JoinColumn
    private  Category category;
}
