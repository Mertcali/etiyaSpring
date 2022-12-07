package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IProductCategoriesService;
import com.etiya.ecommercedemo4.business.dtos.request.productCategories.AddProductCategoriesRequest;
import com.etiya.ecommercedemo4.business.dtos.response.productCategories.AddProductCategoriesResponse;
import com.etiya.ecommercedemo4.entities.concretes.ProductCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productCategories")
public class ProductCategoriesController {

    private IProductCategoriesService productCategoriesService;

    @Autowired
    public ProductCategoriesController(IProductCategoriesService productCategoriesService) {
        this.productCategoriesService = productCategoriesService;
    }

    @GetMapping("/getAll")
    public List<ProductCategories> getAll(){
        return this.productCategoriesService.getAll();
    }

    @GetMapping("{id}")
    public ProductCategories getById(@PathVariable int id){
        return this.productCategoriesService.getById(id);
    }

    @PostMapping("/add")
    public AddProductCategoriesResponse add(@RequestBody AddProductCategoriesRequest addProductCategoriesRequest){
        return this.productCategoriesService.add(addProductCategoriesRequest);
    }

}
