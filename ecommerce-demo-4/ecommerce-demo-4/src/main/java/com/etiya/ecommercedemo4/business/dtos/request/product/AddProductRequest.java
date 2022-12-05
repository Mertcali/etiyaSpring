package com.etiya.ecommercedemo4.business.dtos.request.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class AddProductRequest {

    private String name;
    private double unitPrice;
    private Date productionDate;
    private int stock;

}
