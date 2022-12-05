package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IProductCategoriesService;
import com.etiya.ecommercedemo4.entities.concretes.Product;
import com.etiya.ecommercedemo4.entities.concretes.ProductCategories;
import com.etiya.ecommercedemo4.repository.IProductCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoriesManager implements IProductCategoriesService {
    private IProductCategoriesRepository productCategoriesRepository;

    public ProductCategoriesManager(IProductCategoriesRepository productCategoriesRepository) {
        this.productCategoriesRepository = productCategoriesRepository;
    }

    @Override
    public List<ProductCategories> getAll() {
        return this.productCategoriesRepository.findAll();
    }

    @Override
    public ProductCategories getById(int id) {
        return this.productCategoriesRepository.findById(id).orElseThrow();
    }

}
