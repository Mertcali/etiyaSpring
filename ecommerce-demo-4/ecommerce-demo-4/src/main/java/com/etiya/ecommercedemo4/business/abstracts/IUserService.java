package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.user.AddUserRequest;
import com.etiya.ecommercedemo4.business.dtos.response.user.AddUserResponse;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import com.etiya.ecommercedemo4.entities.concretes.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    Result add(AddUserRequest addUserRequest);
    DataResult<List<User>> getAll();
    DataResult<User> getById(int id);
    Page<User> getAllWithPagination(Pageable pageable);
}
