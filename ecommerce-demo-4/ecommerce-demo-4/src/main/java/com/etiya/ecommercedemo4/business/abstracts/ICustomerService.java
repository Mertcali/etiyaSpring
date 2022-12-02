package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Customer;

import java.util.Date;
import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer getById(int id);

    List<Customer> getAllCustomersWithBirthDate(Date start,Date end);

    List<Customer> getAllCustomersLike(String customerNumber);

    Customer getByCustomerNumber(String customerNumber);

}
