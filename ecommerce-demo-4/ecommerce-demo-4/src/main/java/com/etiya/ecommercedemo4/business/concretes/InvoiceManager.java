package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IInvoiceService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.invoices.AddInvoiceRequest;
import com.etiya.ecommercedemo4.business.dtos.response.invoices.GetInvoiceDto;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessResult;
import com.etiya.ecommercedemo4.entities.concretes.Invoice;
import com.etiya.ecommercedemo4.repository.IInvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceManager implements IInvoiceService {

    private IInvoiceRepository invoiceRepository;
    private ModelMapperService modelMapperService;

    @Override
    public Result add(AddInvoiceRequest addInvoiceRequest) {

        Invoice invoice = this.modelMapperService.forRequest().map(addInvoiceRequest,Invoice.class);
        invoice.setId(0);
        this.invoiceRepository.save(invoice);
        return new SuccessResult(Messages.SuccessMessages.Add);

    }

    @Override
    public DataResult<List<Invoice>> getAll() {
        List<Invoice> response = this.invoiceRepository.findAll();
        return new SuccessDataResult<List<Invoice>>(response,Messages.SuccessMessages.ListAll);
    }

    @Override
    public DataResult<Invoice> getByInvoiceNumber(String invoiceNumber) {
        Invoice response = this.invoiceRepository.findByInvoiceNumber(invoiceNumber);
        return new SuccessDataResult<Invoice>(response,Messages.SuccessMessages.ListByName);
    }

    @Override
    public DataResult<Invoice> getById(int id) {
        Invoice response = this.invoiceRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Invoice>(response,Messages.SuccessMessages.ListById);
    }

    @Override
    public DataResult<GetInvoiceDto> getInvoiceDto(int id) {
        GetInvoiceDto responseDto = this.invoiceRepository.getInvoiceDto(id);
        return new SuccessDataResult<GetInvoiceDto>(responseDto,Messages.SuccessMessages.ListById);
    }
}
