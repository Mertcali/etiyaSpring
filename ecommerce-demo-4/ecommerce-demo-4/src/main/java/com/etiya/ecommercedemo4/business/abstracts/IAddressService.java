package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Address;

import java.util.List;

public interface IAddressService {
    List<Address> getAll();
    Address getById(int id);
}
