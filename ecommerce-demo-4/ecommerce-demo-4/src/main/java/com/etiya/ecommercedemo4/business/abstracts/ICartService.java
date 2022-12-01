package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Cart;

import java.util.List;

public interface ICartService {
    List<Cart> getAll();
    Cart getById(int id);
}
