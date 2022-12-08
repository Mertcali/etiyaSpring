package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICategoryService;
import com.etiya.ecommercedemo4.business.abstracts.IProductCategoriesService;
import com.etiya.ecommercedemo4.business.abstracts.IProductService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo4.business.dtos.request.productCategories.AddProductCategoriesRequest;
import com.etiya.ecommercedemo4.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.Category;
import com.etiya.ecommercedemo4.entities.concretes.Product;
import com.etiya.ecommercedemo4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements IProductService {

    private IProductRepository productRepository;
    private ICategoryService categoryService;
    private IProductCategoriesService productCategoriesService;
    private ModelMapperService modelMapperService;

    @Autowired
    public ProductManager(IProductRepository IProductRepository,ICategoryService categoryService,
                          @Lazy IProductCategoriesService productCategoriesService,ModelMapperService modelMapperService) {
        this.productRepository = IProductRepository;
        this.categoryService =categoryService;
        this.productCategoriesService=productCategoriesService;
        this.modelMapperService=modelMapperService;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllByStock(int stock) {
        return this.productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }

    @Override
    public Product getByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public List<Product> getAllProductsUnitPriceBetween(double start, double end) {
        return this.productRepository.findAllProductsUnitPriceBetween(start,end);
    }

    @Override
    public AddProductResponse add(AddProductRequest addProductRequest) {

        checkIfCategoryExists(addProductRequest.getCategoryId());
        Category category = this.categoryService.getById(addProductRequest.getCategoryId());

        Product product = this.modelMapperService.forRequest().map(addProductRequest,Product.class);
        Product savedProduct = this.productRepository.save(product);
        AddProductResponse response = this.modelMapperService.forResponse().map(savedProduct,AddProductResponse.class);

        return response;

        //********MANUEL_MAPPING***********

        /*
        Product product = new Product();
        product.setName(addProductRequest.getName());
        product.setStock(addProductRequest.getStock());
        product.setUnitPrice(addProductRequest.getUnitPrice());
        product.setProductionDate(addProductRequest.getProductionDate());
         */
        //********MANUEL_MAPPING_RESPONSE***********

        /*
                AddProductResponse response = new AddProductResponse(savedProduct.getId(),
                savedProduct.getName(),savedProduct.getUnitPrice(),
                savedProduct.getProductionDate(),savedProduct.getStock(), category.getName());
         */
        //********PRODUCT_CATEGORIES_SET_PRENSIP_KARŞITI***********

      /*
        AddProductCategoriesRequest addProductCategoriesRequest = new AddProductCategoriesRequest();
        addProductCategoriesRequest.setProductId(response.getId());
        addProductCategoriesRequest.setCategoryId(category.getId());

        this.productCategoriesService.add(addProductCategoriesRequest);
       */


    }

    private void checkIfCategoryExists(int id){
        Category category = this.categoryService.getById(id);
        if(category==null){
            throw new RuntimeException(Messages.Category.CategoryDoesNotExist);
        }
    }


}
