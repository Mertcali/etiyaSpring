package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo4.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo4.business.dtos.response.address.GetAddressDto;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IAddressService {

    Result add(AddAddressRequest addAddressRequest);
    DataResult<List<Address>> getAll();
    DataResult<Address> getById(int id);
    DataResult<List<Address>> getByAddressType();
    DataResult<GetAddressDto> getAddressDto(int id);

    Page<Address> getAllWithPagination(Pageable pageable);

    /*Country getCountryByCityId(int id);
    City getCityByTownId(int id);
    Town getTownByDistrictId(int id);
    District getDistrictByStreetId(int id);
*/

}
