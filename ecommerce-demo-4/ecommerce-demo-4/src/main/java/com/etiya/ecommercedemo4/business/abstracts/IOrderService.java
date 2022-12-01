package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();
    Order getById(int id);
}
