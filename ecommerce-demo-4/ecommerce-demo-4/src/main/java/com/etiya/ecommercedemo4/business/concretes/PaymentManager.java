package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IPaymentService;
import com.etiya.ecommercedemo4.entities.concretes.Payment;
import com.etiya.ecommercedemo4.repository.IPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentManager implements IPaymentService {

    private IPaymentRepository paymentRepository;

    public PaymentManager(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAll() {
        return this.paymentRepository.findAll();
    }

    @Override
    public Payment getById(int id) {
        return this.paymentRepository.findById(id).orElseThrow();
    }
}
