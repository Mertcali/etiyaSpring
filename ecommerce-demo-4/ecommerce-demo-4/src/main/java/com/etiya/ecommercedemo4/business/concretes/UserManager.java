package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IUserService;
import com.etiya.ecommercedemo4.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemo4.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemo4.entities.concretes.User;
import com.etiya.ecommercedemo4.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements IUserService {

    private IUserRepository userRepository;

    public UserManager(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public AddUserResponse add(AddUserRequest addUserRequest) {
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setEmail(addUserRequest.getEmail());
        user.setPhoneNumber(addUserRequest.getPhoneNumber());

        User savedUser = this.userRepository.save(user);

        AddUserResponse response = new AddUserResponse();
        response.setEmail(savedUser.getEmail());
        response.setId(savedUser.getId());
        response.setPhoneNumber(savedUser.getPhoneNumber());
        response.setName(savedUser.getName());
        return response;
    }

    @Override
    public User getById(int id) {
        return this.userRepository.findById(id).orElseThrow();
    }
}
