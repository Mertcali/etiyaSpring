package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IPaymentTypeService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.messages.IMessagesService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.entities.concretes.PaymentType;
import com.etiya.ecommercedemo4.repository.IPaymentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PaymentTypeManager implements IPaymentTypeService {

    private IPaymentTypeRepository paymentTypeRepository;
    private ModelMapperService modelMapperService;
    private IMessagesService messagesService;


    @Override
    public DataResult<List<PaymentType>> getAll() {
        List<PaymentType> response = this.paymentTypeRepository.findAll();
        return new SuccessDataResult<List<PaymentType>>(response,messagesService.getMessage( Messages.SuccessMessages.ListAll));
    }

    @Override
    public Page<PaymentType> getAllWithPagination(Pageable pageable) {
        return this.paymentTypeRepository.findAll(pageable);
    }

    @Override
    public DataResult<PaymentType> getById(int id) {
        PaymentType response = this.paymentTypeRepository.findById(id).orElseThrow();
        return new SuccessDataResult<PaymentType>(response,messagesService.getMessage(Messages.SuccessMessages.ListById));
    }
}
