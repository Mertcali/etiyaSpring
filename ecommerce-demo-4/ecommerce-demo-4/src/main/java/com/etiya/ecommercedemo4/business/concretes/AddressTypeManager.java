package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IAddressTypeService;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import com.etiya.ecommercedemo4.repository.IAddressTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressTypeManager implements IAddressTypeService {

    private IAddressTypeRepository addressTypeRepository;

    public AddressTypeManager(IAddressTypeRepository addressTypeRepository) {
        this.addressTypeRepository = addressTypeRepository;
    }

    @Override
    public List<AddressType> getAll() {
        return this.addressTypeRepository.findAll();
    }

    @Override
    public AddressType getById(int id) {
        return this.addressTypeRepository.findById(id).orElseThrow();
    }
}
