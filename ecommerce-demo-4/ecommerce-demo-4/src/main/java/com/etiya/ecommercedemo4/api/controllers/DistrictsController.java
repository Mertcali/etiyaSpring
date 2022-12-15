package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IDistrictService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.business.dtos.request.district.AddDistrictRequest;
import com.etiya.ecommercedemo4.business.dtos.response.district.AddDistrictResponse;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.entities.concretes.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"districts")
public class DistrictsController {

    private IDistrictService districtService;

    @Autowired
    public DistrictsController(IDistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/getAll")
    public DataResult<List<District>> getAll(){
        return this.districtService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<District> getById(@PathVariable int id){
        return this.districtService.getById(id);
    }

    @PostMapping("/add")
    public Result add(AddDistrictRequest addDistrictRequest){
        return this.districtService.add(addDistrictRequest);
    }

    @GetMapping("/getAllWithPagination")
    public Page<District> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  this.districtService.getAllWithPagination(pageable);
    }
}
