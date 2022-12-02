package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.ICountryService;
import com.etiya.ecommercedemo4.entities.concretes.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountriesController {

    private ICountryService countryService;

    @Autowired
    public CountriesController(ICountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/getAll")
    public List<Country> getAll(){
        return this.countryService.getAll();
    }

    @GetMapping("{id}")
    public Country getById(@PathVariable int id){
        return this.countryService.getById(id);
    }

    @GetMapping("/getAllOrderedByName")
    public List<Country> getAllOrderedByName(){
        return this.countryService.getAllCountriesOrdered();
    }

    @GetMapping("/getByName")
    public Country getByName(String name){
        return this.countryService.getByName(name);
    }
}
