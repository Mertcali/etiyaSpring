package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer getById(int id);
}
