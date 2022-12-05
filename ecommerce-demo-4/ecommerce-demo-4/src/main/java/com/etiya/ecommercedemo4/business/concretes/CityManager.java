package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICityService;
import com.etiya.ecommercedemo4.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo4.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo4.business.dtos.response.city.GetAllCitiesResponse;
import com.etiya.ecommercedemo4.entities.concretes.City;
import com.etiya.ecommercedemo4.repository.ICityRepository;
import com.etiya.ecommercedemo4.repository.ICountryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityManager implements ICityService {

    private ICityRepository cityRepository;
    private ICountryRepository countryRepository;

    public CityManager(ICityRepository cityRepository,ICountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<City> getAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public City getById(int id) {
        return this.cityRepository.findById(id).orElseThrow();
    }

    @Override
    public AddCityResponse add(AddCityRequest addCityRequest) {

        City city = new City();
        city.setName(addCityRequest.getName());
        city.setCountry(this.countryRepository.findById(addCityRequest.getCountryId()).orElseThrow());


        City savedCity = this.cityRepository.save(city);
        AddCityResponse response = new AddCityResponse();
        response.setId(savedCity.getId());
        response.setName(savedCity.getName());
        response.setCountryName(savedCity.getCountry().getName());

        return response;
    }

    @Override
    public List<GetAllCitiesResponse> getAllResponsePattern() {
        List<City> cities = this.cityRepository.findAll();
        List<GetAllCitiesResponse> responseList = new ArrayList<>();

        for(City city:cities){
            GetAllCitiesResponse response = new GetAllCitiesResponse();
            response.setName(city.getName());
            response.setId(city.getId());
            response.setCountryName(city.getCountry().getName());
            responseList.add(response);
        }

        return responseList;
    }
}
