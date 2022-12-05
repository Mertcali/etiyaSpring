package com.etiya.ecommercedemo4.business.dtos.response.category;

import com.etiya.ecommercedemo4.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemo4.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCategoriesWithProductResponse {
    private int id;
    private String name;
    private String productName;
}
