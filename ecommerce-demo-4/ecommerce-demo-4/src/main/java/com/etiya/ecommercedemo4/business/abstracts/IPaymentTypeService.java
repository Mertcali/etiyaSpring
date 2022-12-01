package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.PaymentType;

import java.util.List;

public interface IPaymentTypeService {
    List<PaymentType> getAll();
    PaymentType getById(int id);
}
