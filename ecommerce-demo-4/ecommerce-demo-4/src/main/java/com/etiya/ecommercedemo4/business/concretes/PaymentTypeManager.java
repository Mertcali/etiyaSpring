package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IPaymentService;
import com.etiya.ecommercedemo4.business.abstracts.IPaymentTypeService;
import com.etiya.ecommercedemo4.entities.concretes.Payment;
import com.etiya.ecommercedemo4.entities.concretes.PaymentType;
import com.etiya.ecommercedemo4.repository.IPaymentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeManager implements IPaymentTypeService {

    private IPaymentTypeRepository paymentTypeRepository;

    public PaymentTypeManager(IPaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    @Override
    public List<PaymentType> getAll() {
        return this.paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType getById(int id) {
        return this.paymentTypeRepository.findById(id).orElseThrow();
    }
}
