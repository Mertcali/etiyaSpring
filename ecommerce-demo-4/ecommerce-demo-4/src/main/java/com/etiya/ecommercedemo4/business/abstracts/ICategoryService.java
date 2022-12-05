package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo4.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo4.business.dtos.response.category.GetAllCategoriesWithProductResponse;
import com.etiya.ecommercedemo4.entities.concretes.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAll();
    Category getById(int id);

    AddCategoryResponse add(AddCategoryRequest addCategoryRequest);

    List<GetAllCategoriesWithProductResponse> getAllResponsePattern();

    List<Category> denemeEndPoint(int id);

    List<GetAllCategoriesWithProductResponse> denemeEndPoint2(int id);
}
