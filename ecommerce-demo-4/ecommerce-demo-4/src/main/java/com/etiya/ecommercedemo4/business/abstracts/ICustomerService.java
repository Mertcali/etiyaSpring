package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.customers.AddCustomerRequest;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.Customer;

import java.util.Date;
import java.util.List;

public interface ICustomerService {

    Result add(AddCustomerRequest addCustomerRequest);
    DataResult<List<Customer>> getAll();
    DataResult<Customer> getById(int id);

    DataResult<List<Customer>> getAllCustomersWithBirthDate(Date start,Date end);

    DataResult<List<Customer>> getAllCustomersLike(String customerNumber);

    DataResult<Customer> getByCustomerNumber(String customerNumber);

}
