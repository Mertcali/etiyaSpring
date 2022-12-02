package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getById(int id);
    List<Product> getAllByStock(int stock);
    Product getByName(String name);

    List<Product> getAllProductsUnitPriceBetween(double start,double end);

}
