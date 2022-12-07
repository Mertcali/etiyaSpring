package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICityService;
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
    private ICityService cityService;

    public TownManager(ITownRepository townRepository,ICityService cityService) {
        this.townRepository = townRepository;
        this.cityService = cityService;
    }

    @Override
    public List<Town> getAll() {
        return this.townRepository.findAll();
    }

    @Override
    public AddTownResponse add(AddTownRequest addTownRequest) {

        Town town = new Town();
        town.setCity(this.cityService.getById((addTownRequest.getCityId())));
        town.setName(addTownRequest.getName());

        Town savedTown = this.townRepository.save(town);

        AddTownResponse response = new AddTownResponse();
        response.setId(savedTown.getId());
        response.setName(savedTown.getName());
        response.setCityName(savedTown.getCity().getName());

        return response;
    }

    @Override
    public Town getById(int id) {
        return this.townRepository.findById(id).orElseThrow();
    }
}
