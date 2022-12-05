package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.entities.concretes.Product;
import com.etiya.ecommercedemo4.entities.concretes.ProductCategories;

import java.util.List;

public interface IProductCategoriesService {

    List<ProductCategories> getAll();
    ProductCategories getById(int id);

}
