package com.etiya.ecommercedemo4.business.dtos.request.invoices;

import lombok.*;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddInvoiceRequest {

    @Size(min = 7,max = 7)
    private String invoiceNumber;
    @Positive
    private int orderId;

}
