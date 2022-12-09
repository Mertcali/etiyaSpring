package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IUserService;
import com.etiya.ecommercedemo4.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemo4.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.User;
import com.etiya.ecommercedemo4.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserService {

    private IUserRepository userRepository;
    private ModelMapperService modelMapperService;

    public UserManager(IUserRepository userRepository,ModelMapperService modelMapperService) {
        this.userRepository = userRepository;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public AddUserResponse add(AddUserRequest addUserRequest) {

        User user = this.modelMapperService.forRequest().map(addUserRequest,User.class);
        User savedUser = this.userRepository.save(user);
        AddUserResponse response = this.modelMapperService.forResponse().map(savedUser,AddUserResponse.class);

        return response;
    }

    @Override
    public User getById(int id) {
        return this.userRepository.findById(id).orElseThrow();
    }
}
