package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.ICartService;
import com.etiya.ecommercedemo4.entities.concretes.Cart;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/getall")
public class CartsController {

    private ICartService cartService;

    public CartsController(ICartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/getAll")
    public List<Cart> getAll(){
        return this.cartService.getAll();
    }

    @GetMapping("{id}")
    public Cart getById(@PathVariable int id){
        return this.cartService.getById(id);
    }
}
