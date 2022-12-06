package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo4.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo4.entities.concretes.*;

import java.util.List;

public interface IAddressService {
    List<Address> getAll();
    Address getById(int id);
    List<Address> getByAddressType();

    AddAddressResponse add(AddAddressRequest addAddressRequest);

    /*Country getCountryByCityId(int id);
    City getCityByTownId(int id);
    Town getTownByDistrictId(int id);
    District getDistrictByStreetId(int id);
*/

}
