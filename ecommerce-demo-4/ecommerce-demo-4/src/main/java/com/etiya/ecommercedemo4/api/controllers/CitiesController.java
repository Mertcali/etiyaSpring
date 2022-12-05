package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.ICityService;
import com.etiya.ecommercedemo4.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo4.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo4.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
    private ICityService cityService;

    @Autowired
    public CitiesController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getAll")
    public List<City> getAll(){
        return this.cityService.getAll();
    }

    @GetMapping("{id}")
    public City getById(@PathVariable int id){
        return this.cityService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddCityResponse> add(AddCityRequest addCityRequest){
        return new ResponseEntity<AddCityResponse>(this.cityService.add(addCityRequest), HttpStatus.CREATED);
    }
}
