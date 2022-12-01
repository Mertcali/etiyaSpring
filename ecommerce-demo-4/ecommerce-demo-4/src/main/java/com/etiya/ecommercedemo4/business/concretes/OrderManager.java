package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IOrderService;
import com.etiya.ecommercedemo4.entities.concretes.Order;
import com.etiya.ecommercedemo4.repository.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManager implements IOrderService {

    private IOrderRepository orderRepository;

    public OrderManager(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order getById(int id) {
        return this.orderRepository.findById(id).orElseThrow();
    }
}
