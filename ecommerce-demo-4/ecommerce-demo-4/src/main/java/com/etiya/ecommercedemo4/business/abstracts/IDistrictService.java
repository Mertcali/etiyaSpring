package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.district.AddDistrictRequest;
import com.etiya.ecommercedemo4.business.dtos.response.district.AddDistrictResponse;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import com.etiya.ecommercedemo4.entities.concretes.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDistrictService {
    Result add(AddDistrictRequest addDistrictRequest);
    DataResult<List<District>> getAll();
    DataResult<District> getById(int id);
    Page<District> getAllWithPagination(Pageable pageable);

}
