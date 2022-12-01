package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.OrderDetail;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetail> getAll();
    OrderDetail getById(int id);
}
