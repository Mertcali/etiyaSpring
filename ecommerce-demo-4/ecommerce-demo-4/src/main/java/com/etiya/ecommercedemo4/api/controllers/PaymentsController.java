package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IPaymentService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.entities.concretes.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"payments")
public class PaymentsController {

    private IPaymentService paymentService;

    public PaymentsController(IPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Payment>> getAll(){
        return this.paymentService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<Payment> getById(@PathVariable int id){
        return this.paymentService.getById(id);
    }
    @GetMapping("/getAllWithPagination")
    public Page<Payment> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  this.paymentService.getAllWithPagination(pageable);
    }
}
