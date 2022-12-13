package com.etiya.ecommercedemo4.business.dtos.response.invoices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class GetInvoiceDto {


    private int id;
    private String invoiceNumber;
    private String paymentDescription;

    private String paymentTypeName;

    private int cartQuantity;

    private String productName;
    private double productUnitPrice;
    private String categoryName;

    private String supplierName;
    private String supplierEmail;
    private String customerName;



    private String streetName;
    private String districtName;
    private String townName;
    private String cityName;
    private String countyName;


}
