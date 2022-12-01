package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IProductService;
import com.etiya.ecommercedemo4.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {


    private IProductService IProductService;

    @Autowired
    public ProductsController(IProductService IProductService) {
        this.IProductService = IProductService;
    }

    @GetMapping("/getAll")
    public List<Product> getAll(){
        return this.IProductService.getAll();
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable int id){ return  this.IProductService.getById(id);}

}
