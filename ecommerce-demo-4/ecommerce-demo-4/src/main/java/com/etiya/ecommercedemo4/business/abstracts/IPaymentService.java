package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import com.etiya.ecommercedemo4.entities.concretes.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPaymentService {
    DataResult<List<Payment>> getAll();
    DataResult<Payment> getById(int id);
    Page<Payment> getAllWithPagination(Pageable pageable);
}
