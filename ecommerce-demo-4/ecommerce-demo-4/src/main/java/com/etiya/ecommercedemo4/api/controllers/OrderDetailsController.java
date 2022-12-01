package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IOrderDetailService;
import com.etiya.ecommercedemo4.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderDetails")
public class OrderDetailsController {

    private IOrderDetailService orderDetailService;

    @Autowired
    public OrderDetailsController(IOrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/getAll")
    public List<OrderDetail> getAll(){
        return this.orderDetailService.getAll();
    }

    @GetMapping("{id}")
    public OrderDetail getById(@PathVariable int id){
        return this.orderDetailService.getById(id);
    }

}
