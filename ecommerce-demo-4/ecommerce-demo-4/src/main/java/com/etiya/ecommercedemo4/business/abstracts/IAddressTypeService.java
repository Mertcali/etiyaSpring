package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.AddressType;

import java.util.List;

public interface IAddressTypeService {
    List<AddressType> getAll();
    AddressType getById(int id);
}
