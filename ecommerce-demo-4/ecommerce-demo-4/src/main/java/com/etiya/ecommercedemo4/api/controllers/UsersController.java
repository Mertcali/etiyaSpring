package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IUserService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemo4.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.entities.concretes.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"users")
public class UsersController {

    private IUserService userService;

    public UsersController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody AddUserRequest addUserRequest){
        return this.userService.add(addUserRequest);
    }
    @GetMapping("{id}")
    public DataResult<User> getById(@PathVariable int id){
        return this.userService.getById(id);
    }
    @GetMapping("/getAllWithPagination")
    public Page<User> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  this.userService.getAllWithPagination(pageable);
    }
}
