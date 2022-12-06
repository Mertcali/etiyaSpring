package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.district.AddDistrictRequest;
import com.etiya.ecommercedemo4.business.dtos.response.district.AddDistrictResponse;
import com.etiya.ecommercedemo4.entities.concretes.District;

import java.util.List;

public interface IDistrictService {
    List<District> getAll();
    District getById(int id);

    AddDistrictResponse add(AddDistrictRequest addDistrictRequest);
}
