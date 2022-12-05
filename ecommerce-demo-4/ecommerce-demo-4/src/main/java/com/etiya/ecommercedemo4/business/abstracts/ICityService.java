package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo4.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo4.business.dtos.response.city.GetAllCitiesResponse;
import com.etiya.ecommercedemo4.entities.concretes.City;

import java.util.List;

public interface ICityService {
    List<City> getAll();
    City getById(int id);
    AddCityResponse add(AddCityRequest addCityRequest);

    List<GetAllCitiesResponse> getAllResponsePattern();
}
