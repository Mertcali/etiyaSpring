package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICartService;
import com.etiya.ecommercedemo4.entities.concretes.Cart;
import com.etiya.ecommercedemo4.repository.ICartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartManager implements ICartService {

    private ICartRepository cartRepository;

    public CartManager(ICartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> getAll() {
        return this.cartRepository.findAll();
    }

    @Override
    public Cart getById(int id) {
        return this.cartRepository.findById(id).orElseThrow();
    }
}
