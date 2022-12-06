package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICategoryService;
import com.etiya.ecommercedemo4.business.abstracts.IProductCategoriesService;
import com.etiya.ecommercedemo4.business.abstracts.IProductService;
import com.etiya.ecommercedemo4.business.dtos.request.productCategories.AddProductCategoriesRequest;
import com.etiya.ecommercedemo4.business.dtos.response.productCategories.AddProductCategoriesResponse;
import com.etiya.ecommercedemo4.entities.concretes.ProductCategories;
import com.etiya.ecommercedemo4.repository.IProductCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoriesManager implements IProductCategoriesService {
    private IProductCategoriesRepository productCategoriesRepository;
    private ICategoryService categoryService;
    private IProductService productService;

    public ProductCategoriesManager(IProductCategoriesRepository productCategoriesRepository,ICategoryService categoryService,
                                    IProductService productService) {
        this.productCategoriesRepository = productCategoriesRepository;
        this.categoryService = categoryService;
        this.productService=productService;
    }

    @Override
    public List<ProductCategories> getAll() {
        return this.productCategoriesRepository.findAll();
    }

    @Override
    public ProductCategories getById(int id) {
        return this.productCategoriesRepository.findById(id).orElseThrow();
    }

    @Override
    public AddProductCategoriesResponse add(AddProductCategoriesRequest addProductCategoriesRequest) {
        ProductCategories productCategories = new ProductCategories();
        productCategories.setCategory(this.categoryService.getById(addProductCategoriesRequest.getCategoryId()));
        productCategories.setProduct(this.productService.getById(addProductCategoriesRequest.getProductId()));

        ProductCategories savedProductCategories = this.productCategoriesRepository.save(productCategories);

        AddProductCategoriesResponse response = new AddProductCategoriesResponse();

        response.setCategoryId(savedProductCategories.getCategory().getId());
        response.setProductId(savedProductCategories.getProduct().getId());
        response.setId(savedProductCategories.getId());

        return response;
    }
}
