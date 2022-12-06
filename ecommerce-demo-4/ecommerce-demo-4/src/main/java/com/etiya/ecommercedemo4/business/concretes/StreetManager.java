package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IStreetService;
import com.etiya.ecommercedemo4.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo4.business.dtos.response.street.AddStreetResponse;
import com.etiya.ecommercedemo4.entities.concretes.Street;
import com.etiya.ecommercedemo4.repository.IDistrictRepository;
import com.etiya.ecommercedemo4.repository.IStreetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetManager implements IStreetService {

    private IStreetRepository streetRepository;
    private IDistrictRepository districtRepository;

    public StreetManager(IStreetRepository streetRepository, IDistrictRepository districtRepository) {
        this.streetRepository = streetRepository;
        this.districtRepository = districtRepository;
    }

    @Override
    public List<Street> getAll() {
        return this.streetRepository.findAll();
    }

    @Override
    public AddStreetResponse add(AddStreetRequest addStreetRequest) {
        Street street = new Street();
        street.setName(addStreetRequest.getName());
        street.setDistrict(this.districtRepository.findById(addStreetRequest.getDistrictId()).orElseThrow());

        Street savedStreet = this.streetRepository.save(street);

        AddStreetResponse response = new AddStreetResponse();
        response.setId(savedStreet.getId());
        response.setName(savedStreet.getName());
        response.setDistrictName(savedStreet.getDistrict().getName());

        return response;
    }

    @Override
    public Street getById(int id) {
        return this.streetRepository.findById(id).orElseThrow();
    }
}
