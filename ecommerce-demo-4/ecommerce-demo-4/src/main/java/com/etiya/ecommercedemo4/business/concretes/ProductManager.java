package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IProductService;
import com.etiya.ecommercedemo4.entities.concretes.Product;
import com.etiya.ecommercedemo4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements IProductService {

    private IProductRepository IProductRepository;

    @Autowired
    public ProductManager(IProductRepository IProductRepository) {
        this.IProductRepository = IProductRepository;
    }

    @Override
    public List<Product> getAll() {
        return IProductRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return IProductRepository.findById(id).orElseThrow();
    }
}
