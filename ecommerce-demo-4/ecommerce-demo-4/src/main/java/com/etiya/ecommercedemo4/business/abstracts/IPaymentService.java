package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Payment;

import java.util.List;

public interface IPaymentService {
    List<Payment> getAll();
    Payment getById(int id);
}
