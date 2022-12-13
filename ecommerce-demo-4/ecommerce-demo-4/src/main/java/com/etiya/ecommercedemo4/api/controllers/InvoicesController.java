package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IInvoiceService;
import com.etiya.ecommercedemo4.business.dtos.request.invoices.AddInvoiceRequest;
import com.etiya.ecommercedemo4.business.dtos.response.invoices.GetInvoiceDto;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.Invoice;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoicesController {

    private IInvoiceService invoiceService;

    public InvoicesController(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddInvoiceRequest addInvoiceRequest){
        return this.invoiceService.add(addInvoiceRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<Invoice>> getAll(){
        return this.invoiceService.getAll();
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public DataResult<Invoice> getById(@PathVariable int id){
        return this.invoiceService.getById(id);
    }

    @RequestMapping(value = "/getByInvoiceNumber/{invoiceNumber}", method = RequestMethod.GET)
        public DataResult<Invoice> getByInvoiceNumber(@PathVariable String invoiceNumber){
        return this.invoiceService.getByInvoiceNumber(invoiceNumber);
    }

    @RequestMapping(value = "/getByInvoiceByIdDto/{id}", method = RequestMethod.GET)
    public DataResult<GetInvoiceDto> getInvoiceDto(@PathVariable int id){
        return this.invoiceService.getInvoiceDto(id);
    }
}
