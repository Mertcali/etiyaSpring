package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICityService;
import com.etiya.ecommercedemo4.business.abstracts.ITownService;
import com.etiya.ecommercedemo4.business.dtos.request.town.AddTownRequest;
import com.etiya.ecommercedemo4.business.dtos.response.town.AddTownResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.Town;
import com.etiya.ecommercedemo4.repository.ICityRepository;
import com.etiya.ecommercedemo4.repository.ITownRepository;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownManager implements ITownService {

    private ITownRepository townRepository;
    private ICityService cityService;
    private ModelMapperService modelMapperService;

    public TownManager(ITownRepository townRepository,ICityService cityService,ModelMapperService modelMapperService) {
        this.townRepository = townRepository;
        this.cityService = cityService;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<Town> getAll() {
        return this.townRepository.findAll();
    }

    @Override
    public AddTownResponse add(AddTownRequest addTownRequest) {

        /*
        TypeMap<AddTownRequest, Town> propertyMapper = this.modelMapperService.
                getMappingStandard().createTypeMap(AddTownRequest.class, Town.class);
        propertyMapper.addMappings(mapper -> mapper.skip(Town::setId));

         */

        Town town = this.modelMapperService.forRequest().map(addTownRequest,Town.class);



        Town savedTown = this.townRepository.save(town);
        AddTownResponse response = this.modelMapperService.forResponse().map(savedTown,AddTownResponse.class);

        return response;

    }

    @Override
    public Town getById(int id) {
        return this.townRepository.findById(id).orElseThrow();
    }
}
