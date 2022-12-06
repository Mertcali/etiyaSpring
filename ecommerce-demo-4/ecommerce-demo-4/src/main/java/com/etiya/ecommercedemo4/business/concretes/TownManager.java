package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ITownService;
import com.etiya.ecommercedemo4.business.dtos.request.town.AddTownRequest;
import com.etiya.ecommercedemo4.business.dtos.response.town.AddTownResponse;
import com.etiya.ecommercedemo4.entities.concretes.Town;
import com.etiya.ecommercedemo4.repository.ICityRepository;
import com.etiya.ecommercedemo4.repository.ITownRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownManager implements ITownService {

    private ITownRepository townRepository;
    private ICityRepository cityRepository;

    public TownManager(ITownRepository townRepository,ICityRepository cityRepository) {
        this.townRepository = townRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<Town> getAll() {
        return this.townRepository.findAll();
    }

    @Override
    public AddTownResponse add(AddTownRequest addTownRequest) {

        Town town = new Town();
        town.setCity(this.cityRepository.findById(addTownRequest.getCityId()).orElseThrow());
        town.setName(addTownRequest.getName());

        Town savedTown = this.townRepository.save(town);

        AddTownResponse response = new AddTownResponse();
        response.setId(savedTown.getId());
        response.setName(savedTown.getName());
        response.setCityName(savedTown.getCity().getName());

        return response;
    }
}
