package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IAddressService;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressesController {

    private IAddressService addressService;

    @Autowired
    public AddressesController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/getAll")
    public List<Address> getAll(){
        return this.addressService.getAll();
    }

    @GetMapping("{id}")
    public Address getById(@PathVariable int id){
        return this.addressService.getById(id);
    }

    @GetMapping("/getByAdressType")
    public List<Address> getByAddressType(){
        return this.addressService.getByAddressType();
    }
}
