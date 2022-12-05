package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICategoryService;
import com.etiya.ecommercedemo4.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo4.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo4.entities.concretes.Category;
import com.etiya.ecommercedemo4.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {

    private ICategoryRepository categoryRepository;

    public CategoryManager(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return this.categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public AddCategoryResponse add(AddCategoryRequest addCategoryRequest) {
        Category category = new Category();
        category.setName(addCategoryRequest.getName());

        Category savedCategory = this.categoryRepository.save(category);

        AddCategoryResponse response = new AddCategoryResponse();
        response.setId(savedCategory.getId());
        response.setName(savedCategory.getName());

        return response;
    }
}
