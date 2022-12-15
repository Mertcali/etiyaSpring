package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo4.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo4.business.dtos.response.category.GetCategoryByIdWithProductsResponse;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import com.etiya.ecommercedemo4.entities.concretes.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {


    Result add(AddCategoryRequest addCategoryRequest);
    DataResult<List<Category>> getAll();
    DataResult<Category> getById(int id);
    DataResult<List<GetCategoryByIdWithProductsResponse>> getAllDto(int id);
    Page<Category> getAllWithPagination(Pageable pageable);
}
