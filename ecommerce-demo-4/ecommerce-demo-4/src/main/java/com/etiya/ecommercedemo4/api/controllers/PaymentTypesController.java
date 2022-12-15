package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IPaymentTypeService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.entities.concretes.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"paymentTypes")
public class PaymentTypesController {
    private IPaymentTypeService paymentTypeService;

    @Autowired
    public PaymentTypesController(IPaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping("/getall")
    public DataResult<List<PaymentType>> getAll(){
        return this.paymentTypeService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<PaymentType> getById(@PathVariable int id){
        return this.paymentTypeService.getById(id);
    }

    @GetMapping("/getAllWithPagination")
    public Page<PaymentType> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  this.paymentTypeService.getAllWithPagination(pageable);
    }
}
