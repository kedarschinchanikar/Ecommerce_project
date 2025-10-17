package com.example.productservice.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseProductModel  {
    private long Id;
    private Data CreateAt;
    private Data LastModifiedAt;
}
