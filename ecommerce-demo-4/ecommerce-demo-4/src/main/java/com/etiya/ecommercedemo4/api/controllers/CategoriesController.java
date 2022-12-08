package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.ICategoryService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo4.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo4.business.dtos.response.category.GetAllCategoriesWithProductResponse;
import com.etiya.ecommercedemo4.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"categories")
public class CategoriesController {

    private ICategoryService categoryService;

    @Autowired
    public CategoriesController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return this.categoryService.getAll();
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable int id){
        return this.categoryService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<AddCategoryResponse> add(@RequestBody @Valid AddCategoryRequest addCategoryRequest){
        return new ResponseEntity<AddCategoryResponse>(this.categoryService.add(addCategoryRequest),
                HttpStatus.CREATED);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public List<Category> denemeEndPoint(@PathVariable int id){
        return this.categoryService.denemeEndPoint(id);
    }

    @RequestMapping(value = "/id2/{id}", method = RequestMethod.GET)
    public List<GetAllCategoriesWithProductResponse> denemeEndPoint2(@PathVariable int id){
        return this.categoryService.denemeEndPoint2(id);
    }
}
