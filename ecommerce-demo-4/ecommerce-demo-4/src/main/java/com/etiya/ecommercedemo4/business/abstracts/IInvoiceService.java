package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.invoices.AddInvoiceRequest;
import com.etiya.ecommercedemo4.business.dtos.response.invoices.GetInvoiceDto;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.Invoice;

import java.util.List;

public interface IInvoiceService {

    Result add(AddInvoiceRequest addInvoiceRequest);

    DataResult<List<Invoice>> getAll();

    DataResult<Invoice> getByInvoiceNumber(String invoiceNumber);

    DataResult<Invoice> getById(int id);
    DataResult<GetInvoiceDto> getInvoiceDto(int id);


}
