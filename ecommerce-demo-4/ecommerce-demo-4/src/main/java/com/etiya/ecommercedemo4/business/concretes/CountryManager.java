package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICountryService;
import com.etiya.ecommercedemo4.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo4.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo4.entities.concretes.Country;
import com.etiya.ecommercedemo4.repository.ICountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryManager implements ICountryService {

    private ICountryRepository countryRepository;

    public CountryManager(ICountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country getById(int id) {
        return this.countryRepository.findById(id).orElseThrow();
    }

    @Override
    public Country getByName(String name) {
        return this.countryRepository.findByName(name);
    }

    @Override
    public List<Country> getAllCountriesOrdered() {
        return this.countryRepository.findAllCountriesOrderByName();
    }

    @Override
    public AddCountryResponse add(AddCountryRequest addCountryRequest) {

        Country country = new Country();
        country.setName(addCountryRequest.getName());

        Country savedCountry = this.countryRepository.save(country);

        AddCountryResponse response = new AddCountryResponse(savedCountry.getId(), savedCountry.getName());

        return response;
    }
}
