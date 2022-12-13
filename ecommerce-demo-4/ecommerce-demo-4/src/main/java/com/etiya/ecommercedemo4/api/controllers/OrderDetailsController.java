package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IOrderDetailService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.business.dtos.request.orderDetails.AddOrderDetailRequest;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"orderDetails")
public class OrderDetailsController {

    private IOrderDetailService orderDetailService;

    @Autowired
    public OrderDetailsController(IOrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/getAll")
    public DataResult<List<OrderDetail>> getAll(){
        return this.orderDetailService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<OrderDetail> getById(@PathVariable int id){
        return this.orderDetailService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddOrderDetailRequest addOrderDetailRequest){
        return this.orderDetailService.add(addOrderDetailRequest);
    }
}
