package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();
    Category getById(int id);
}
