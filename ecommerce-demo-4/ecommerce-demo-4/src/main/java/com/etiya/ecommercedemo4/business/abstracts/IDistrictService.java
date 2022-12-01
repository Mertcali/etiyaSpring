package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.District;

import java.util.List;

public interface IDistrictService {
    List<District> getAll();
    District getById(int id);
}
