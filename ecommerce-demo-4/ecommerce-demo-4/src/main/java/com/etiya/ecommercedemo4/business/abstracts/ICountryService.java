package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAll();
    Country getById(int id);

}
