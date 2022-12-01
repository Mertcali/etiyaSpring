package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IOrderDetailService;
import com.etiya.ecommercedemo4.entities.concretes.OrderDetail;
import com.etiya.ecommercedemo4.repository.IOrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailManager implements IOrderDetailService {

    private IOrderDetailRepository orderDetailRepository;

    public OrderDetailManager(IOrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> getAll() {
        return this.orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getById(int id) {
        return this.orderDetailRepository.findById(id).orElseThrow();
    }
}
