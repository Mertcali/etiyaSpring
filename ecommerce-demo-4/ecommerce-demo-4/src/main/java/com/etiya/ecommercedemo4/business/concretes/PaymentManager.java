package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IPaymentService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.messages.IMessagesService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.entities.concretes.Payment;
import com.etiya.ecommercedemo4.repository.IPaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentManager implements IPaymentService {

    private IPaymentRepository paymentRepository;

    private ModelMapperService modelMapperService;

    private IMessagesService messagesService;

    //TODO : ADD
    @Override
    public DataResult<List<Payment>> getAll() {
        List<Payment> response = this.paymentRepository.findAll();

        return new SuccessDataResult<List<Payment>>(response,messagesService.getMessage(Messages.SuccessMessages.ListAll));
    }

    @Override
    public Page<Payment> getAllWithPagination(Pageable pageable) {
        return this.paymentRepository.findAll(pageable);
    }

    @Override
    public DataResult<Payment> getById(int id) {
        Payment response = this.paymentRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Payment>(response,messagesService.getMessage(Messages.SuccessMessages.ListById));
    }
}
