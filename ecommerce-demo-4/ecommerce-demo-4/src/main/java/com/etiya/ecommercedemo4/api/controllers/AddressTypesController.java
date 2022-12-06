package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IAddressTypeService;
import com.etiya.ecommercedemo4.business.dtos.request.addressType.AddAddressTypeRequest;
import com.etiya.ecommercedemo4.business.dtos.response.addressType.AddAddressTypeResponse;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<AddAddressTypeResponse> add(@RequestBody AddAddressTypeRequest addAddressTypeRequest){
        return new ResponseEntity<AddAddressTypeResponse>(this.addressTypeService.add(addAddressTypeRequest),
                HttpStatus.CREATED);
    }


}
