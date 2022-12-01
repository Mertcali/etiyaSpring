package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICityService;
import com.etiya.ecommercedemo4.entities.concretes.City;
import com.etiya.ecommercedemo4.repository.ICityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements ICityService {

    private ICityRepository cityRepository;

    public CityManager(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public City getById(int id) {
        return this.cityRepository.findById(id).orElseThrow();
    }
}
