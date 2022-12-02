package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICustomerService;
import com.etiya.ecommercedemo4.entities.concretes.Customer;
import com.etiya.ecommercedemo4.repository.ICustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerManager implements ICustomerService {

    private ICustomerRepository customerRepository;

    public CustomerManager(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return this.customerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Customer> getAllCustomersWithBirthDate(Date start, Date end) {
        return this.customerRepository.findAllCustomersWithBirthDate(start,end);
    }

    @Override
    public List<Customer> getAllCustomersLike(String customerNumber) {
        return this.customerRepository.findAllCustomersLike(customerNumber);
    }

    @Override
    public Customer getByCustomerNumber(String customerNumber) {
        return this.customerRepository.findByCustomerNumber(customerNumber);
    }



}
