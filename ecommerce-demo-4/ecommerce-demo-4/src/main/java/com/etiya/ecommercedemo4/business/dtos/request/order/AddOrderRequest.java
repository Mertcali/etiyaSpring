package com.etiya.ecommercedemo4.business.dtos.request.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddOrderRequest {

    @NotNull
    @Positive
    private int paymentId;
    @NotNull
    @Positive
    private int orderDetailId;
}
