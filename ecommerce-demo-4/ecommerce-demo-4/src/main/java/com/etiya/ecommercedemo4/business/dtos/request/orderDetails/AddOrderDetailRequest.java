package com.etiya.ecommercedemo4.business.dtos.request.orderDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddOrderDetailRequest {

    @NotNull
    @Positive
    private int productSuppliersId;

    @NotNull
    @Positive
    private int productSupplierCartId;
}
