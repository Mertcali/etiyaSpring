package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.addressType.AddAddressTypeRequest;
import com.etiya.ecommercedemo4.business.dtos.response.address.AddAddressTypeResponse;
import com.etiya.ecommercedemo4.entities.concretes.Address;

import java.util.List;

public interface IAddressService {
    List<Address> getAll();
    Address getById(int id);
    List<Address> getByAddressType();


}
