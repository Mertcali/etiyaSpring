package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IOrderService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"orders")
public class OrdersController {

    private IOrderService orderService;

    @Autowired
    public OrdersController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Order>> getAll(){
        return this.orderService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<Order> getById(@PathVariable int id){
        return this.orderService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddOrderRequest addOrderRequest){
        return this.orderService.add(addOrderRequest);
    }

}
