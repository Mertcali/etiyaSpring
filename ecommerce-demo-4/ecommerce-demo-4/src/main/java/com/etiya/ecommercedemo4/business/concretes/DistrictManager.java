package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IDistrictService;
import com.etiya.ecommercedemo4.business.abstracts.ITownService;
import com.etiya.ecommercedemo4.business.dtos.request.district.AddDistrictRequest;
import com.etiya.ecommercedemo4.business.dtos.response.district.AddDistrictResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.District;
import com.etiya.ecommercedemo4.repository.IDistrictRepository;
import com.etiya.ecommercedemo4.repository.ITownRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictManager implements IDistrictService {

    private IDistrictRepository districtRepository;
    private ITownService townService;
    private ModelMapperService modelMapperService;


    public DistrictManager(IDistrictRepository districtRepository,ITownService townService,ModelMapperService modelMapperService) {
        this.districtRepository = districtRepository;
        this.townService = townService;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public List<District> getAll() {
        return this.districtRepository.findAll();
    }

    @Override
    public District getById(int id) {
        return this.districtRepository.findById(id).orElseThrow();
    }

    @Override
    public AddDistrictResponse add(AddDistrictRequest addDistrictRequest) {

        District district = this.modelMapperService.getMappingStandard().map(addDistrictRequest,District.class);
        District savedDistrict = this.districtRepository.save(district);
        AddDistrictResponse response = this.modelMapperService.getMappingStandard().map(savedDistrict,AddDistrictResponse.class);

        return response;

        //*****MANUEL_MAPPING*****
        /*
        District district = new District();
        district.setName(addDistrictRequest.getName());
        district.setTown(this.townService.getById(addDistrictRequest.getTownId()));

        District savedDistrict = this.districtRepository.save(district);

        AddDistrictResponse response = new AddDistrictResponse();
        response.setId(savedDistrict.getId());
        response.setTownName(savedDistrict.getTown().getName());
        response.setName(savedDistrict.getName());

         */
    }
}
