package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.ICountryService;
import com.etiya.ecommercedemo4.entities.concretes.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountriesController {

    private ICountryService countryService;

    public CountriesController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/getAll")
    public List<Country> getAll(){
        return this.countryService.getAll();
    }

    @GetMapping("{id}")
    public Country getById(int id){
        return this.countryService.getById(id);
    }
}
