package com.etiya.ecommercedemo4.business.dtos.response.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class AddProductResponse {

    private int id;
    private String name;
    private double unitPrice;
    private Date productionDate;
    private int stock;
}
