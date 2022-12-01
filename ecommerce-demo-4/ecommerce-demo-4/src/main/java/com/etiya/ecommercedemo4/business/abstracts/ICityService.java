package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.City;

import java.util.List;

public interface ICityService {
    List<City> getAll();
    City getById(int id);
}
