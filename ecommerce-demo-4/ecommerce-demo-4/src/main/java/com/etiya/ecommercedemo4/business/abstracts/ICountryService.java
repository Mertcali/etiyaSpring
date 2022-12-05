package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo4.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo4.entities.concretes.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getAll();
    Country getById(int id);
    Country getByName(String name);
    List<Country> getAllCountriesOrdered();

    AddCountryResponse add(AddCountryRequest addCountryRequest);

}
