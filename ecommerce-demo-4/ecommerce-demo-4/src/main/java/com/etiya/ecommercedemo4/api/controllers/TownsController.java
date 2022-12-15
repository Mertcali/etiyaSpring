package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.ITownService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.business.dtos.request.town.AddTownRequest;
import com.etiya.ecommercedemo4.business.dtos.response.town.AddTownResponse;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.entities.concretes.Town;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"towns")
public class TownsController {

    ITownService townService;

    public TownsController(ITownService townService) {
        this.townService = townService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Town>> getAll(){
        return this.townService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody AddTownRequest addTownRequest){
        return this.townService.add(addTownRequest);
    }
    @GetMapping("/getAllWithPagination")
    public Page<Town> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  this.townService.getAllWithPagination(pageable);
    }
}

