package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IDistrictService;
import com.etiya.ecommercedemo4.entities.concretes.District;
import com.etiya.ecommercedemo4.repository.IDistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictManager implements IDistrictService {

    private IDistrictRepository districtRepository;

    public DistrictManager(IDistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public List<District> getAll() {
        return this.districtRepository.findAll();
    }

    @Override
    public District getById(int id) {
        return this.districtRepository.findById(id).orElseThrow();
    }
}
