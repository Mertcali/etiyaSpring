package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IAddressTypeService;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get/addresstypes")
public class AddressTypesController {
    private IAddressTypeService addressTypeService;

    @Autowired
    public AddressTypesController(IAddressTypeService addressTypeService) {
        this.addressTypeService = addressTypeService;
    }

    @GetMapping("/getall")
    public List<AddressType> getAll(){
        return this.addressTypeService.getAll();
    }

    @GetMapping("{id}")
    public AddressType getById(@PathVariable int id){
        return this.addressTypeService.getById(id);
    }


}
