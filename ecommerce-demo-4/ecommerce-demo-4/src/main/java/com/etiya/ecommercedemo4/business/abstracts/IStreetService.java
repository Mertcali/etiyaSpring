package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo4.business.dtos.response.street.AddStreetResponse;
import com.etiya.ecommercedemo4.entities.concretes.Street;

import java.util.List;

public interface IStreetService {

    List<Street> getAll();
    AddStreetResponse add(AddStreetRequest addStreetRequest);

    Street getById(int id);
}
