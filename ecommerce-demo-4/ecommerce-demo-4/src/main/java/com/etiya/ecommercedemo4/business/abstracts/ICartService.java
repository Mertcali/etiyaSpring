package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import com.etiya.ecommercedemo4.entities.concretes.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICartService {
    DataResult<List<Cart>> getAll();
    DataResult<Cart> getById(int id);

    Result add(AddCartRequest addCartRequest);
    Page<Cart> getAllWithPagination(Pageable pageable);


}
