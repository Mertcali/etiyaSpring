package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IPaymentTypeService;
import com.etiya.ecommercedemo4.entities.concretes.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/paymentTypes")
public class PaymentTypesController {
    private IPaymentTypeService paymentTypeService;

    @Autowired
    public PaymentTypesController(IPaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping("/getall")
    public List<PaymentType> getAll(){
        return this.paymentTypeService.getAll();
    }

    @GetMapping("{id}")
    public PaymentType getById(@PathVariable int id){
        return this.paymentTypeService.getById(id);
    }

}
