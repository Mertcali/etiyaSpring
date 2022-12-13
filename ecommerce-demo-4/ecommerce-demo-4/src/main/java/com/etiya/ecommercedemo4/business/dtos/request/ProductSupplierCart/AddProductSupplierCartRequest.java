package com.etiya.ecommercedemo4.business.dtos.request.ProductSupplierCart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AddProductSupplierCartRequest {

    @NotNull
    @Positive
    private int cartId;
    @NotNull
    @Positive
    private int productSupplierId;
}
