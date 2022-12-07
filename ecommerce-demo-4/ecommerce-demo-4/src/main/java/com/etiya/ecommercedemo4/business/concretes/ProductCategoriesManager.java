package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICategoryService;
import com.etiya.ecommercedemo4.business.abstracts.IProductCategoriesService;
import com.etiya.ecommercedemo4.business.abstracts.IProductService;
import com.etiya.ecommercedemo4.business.dtos.request.productCategories.AddProductCategoriesRequest;
import com.etiya.ecommercedemo4.business.dtos.response.productCategories.AddProductCategoriesResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.ProductCategories;
import com.etiya.ecommercedemo4.repository.IProductCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoriesManager implements IProductCategoriesService {
    private IProductCategoriesRepository productCategoriesRepository;
    private ICategoryService categoryService;
    private IProductService productService;
    private ModelMapperService modelMapperService;

    public ProductCategoriesManager(IProductCategoriesRepository productCategoriesRepository,ICategoryService categoryService,
                                    IProductService productService,ModelMapperService modelMapperService) {
        this.productCategoriesRepository = productCategoriesRepository;
        this.categoryService = categoryService;
        this.productService=productService;
        this.modelMapperService = modelMapperService;
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

        ProductCategories productCategories = this.modelMapperService.forRequest().map(addProductCategoriesRequest,ProductCategories.class);
        ProductCategories savedProductCategories = this.productCategoriesRepository.save(productCategories);
        AddProductCategoriesResponse response = this.modelMapperService.forResponse().map(savedProductCategories,AddProductCategoriesResponse.class);

        return response;

        //******MANUEL_MAPPING******

        /*
        ProductCategories productCategories = new ProductCategories();
        productCategories.setCategory(this.categoryService.getById(addProductCategoriesRequest.getCategoryId()));
        productCategories.setProduct(this.productService.getById(addProductCategoriesRequest.getProductId()));

         */
        //******MANUEL_MAPPING_RESPONSE******

        /*
        AddProductCategoriesResponse response = new AddProductCategoriesResponse();

        response.setCategoryId(savedProductCategories.getCategory().getId());
        response.setProductId(savedProductCategories.getProduct().getId());
        response.setId(savedProductCategories.getId());
         */
    }
}
