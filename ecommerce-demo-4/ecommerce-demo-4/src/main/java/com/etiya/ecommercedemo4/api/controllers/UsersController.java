package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IUserService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemo4.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemo4.entities.concretes.User;
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
    public List<User> getAll(){
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public AddUserResponse add(@RequestBody AddUserRequest addUserRequest){
        return this.userService.add(addUserRequest);
    }
}
