package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IAddressService;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.repository.IAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressManager implements IAddressService {

    private IAddressRepository addressRepository;

    public AddressManager(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getById(int id) {
        return this.addressRepository.findById(id).orElseThrow();
    }
}
