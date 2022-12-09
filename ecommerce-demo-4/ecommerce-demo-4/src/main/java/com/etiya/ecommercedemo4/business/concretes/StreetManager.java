package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IDistrictService;
import com.etiya.ecommercedemo4.business.abstracts.IStreetService;
import com.etiya.ecommercedemo4.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo4.business.dtos.response.street.AddStreetResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.Street;
import com.etiya.ecommercedemo4.repository.IDistrictRepository;
import com.etiya.ecommercedemo4.repository.IStreetRepository;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetManager implements IStreetService {

    private IStreetRepository streetRepository;
    private IDistrictService districtService;
    private ModelMapperService modelMapperService;

    public StreetManager(IStreetRepository streetRepository, IDistrictService districtService,ModelMapperService modelMapperService) {
        this.streetRepository = streetRepository;
        this.districtService = districtService;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<Street> getAll() {
        return this.streetRepository.findAll();
    }

    @Override
    public AddStreetResponse add(AddStreetRequest addStreetRequest) {


        Street street = this.modelMapperService.forRequest().map(addStreetRequest,Street.class);
        Street savedStreet = this.streetRepository.save(street);
        AddStreetResponse response = this.modelMapperService.forResponse().map(savedStreet,AddStreetResponse.class);

        return response;

        //*****MANUEL_MAPPING*****
        /*
        Street street = new Street();
        street.setName(addStreetRequest.getName());
        street.setDistrict(this.districtService.getById((addStreetRequest.getDistrictId())));

        Street savedStreet = this.streetRepository.save(street);

        AddStreetResponse response = new AddStreetResponse();
        response.setId(savedStreet.getId());
        response.setName(savedStreet.getName());
        response.setDistrictName(savedStreet.getDistrict().getName());

         */

    }

    @Override
    public Street getById(int id) {
        return this.streetRepository.findById(id).orElseThrow();
    }
}
