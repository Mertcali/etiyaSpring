package com.etiya.ecommercedemo4.business.dtos.request.customers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCustomerRequest {

    private Date birthDate;
    private String customerNumber;
    private String email;
    private String name;
    private String phoneNumber;
}
