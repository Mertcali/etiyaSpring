package com.etiya.ecommercedemo4.business.abstracts;


import com.etiya.ecommercedemo4.business.dtos.request.town.AddTownRequest;
import com.etiya.ecommercedemo4.business.dtos.response.town.AddTownResponse;
import com.etiya.ecommercedemo4.entities.concretes.Town;

import java.util.List;

public interface ITownService {

    List<Town> getAll();

    AddTownResponse add(AddTownRequest addTownRequest);
    Town getById(int id);
}
