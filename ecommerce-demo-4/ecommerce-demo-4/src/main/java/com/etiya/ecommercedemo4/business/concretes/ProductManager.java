package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ICategoryService;
import com.etiya.ecommercedemo4.business.abstracts.IProductCategoriesService;
import com.etiya.ecommercedemo4.business.abstracts.IProductService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo4.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo4.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessResult;
import com.etiya.ecommercedemo4.entities.concretes.Category;
import com.etiya.ecommercedemo4.entities.concretes.Product;
import com.etiya.ecommercedemo4.repository.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductManager implements IProductService {

    private IProductRepository productRepository;
    private ICategoryService categoryService;
    private IProductCategoriesService productCategoriesService;
    private ModelMapperService modelMapperService;

    public ProductManager(IProductRepository productRepository,
                          ICategoryService categoryService,
                          @Lazy IProductCategoriesService productCategoriesService,
                          ModelMapperService modelMapperService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.productCategoriesService = productCategoriesService;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        List<Product> response = productRepository.findAll();
        return new SuccessDataResult<List<Product>>(response,Messages.SuccessMessages.ListAll);
    }

    @Override
    public DataResult<Product> getById(int id) {
        Product response = productRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Product>(response,Messages.SuccessMessages.ListById);
    }

    @Override
    public DataResult<List<Product>> getAllByStock(int stock) {
        List<Product> response = this.productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
        return new SuccessDataResult<List<Product>>(response,Messages.SuccessMessages.ListAll);
    }

    @Override
    public DataResult<Product> getByName(String name) {
        Product response = this.productRepository.findByName(name);
        return new SuccessDataResult<Product>(response,Messages.SuccessMessages.ListByName);
    }

    @Override
    public DataResult<List<Product>> getAllProductsUnitPriceBetween(double start, double end) {
        List<Product> response = this.productRepository.findAllProductsUnitPriceBetween(start,end);
        return new SuccessDataResult<List<Product>>(response,Messages.SuccessMessages.Succeeded);
    }

    @Override
    public Result add(AddProductRequest addProductRequest) {

        //TODO : CHECKIF TAŞINACAK.
        Product product = this.modelMapperService.forRequest().map(addProductRequest,Product.class);
        //checkIfCategoryExists(addProductRequest.getProductCategoryId());
        product.setId(0);
        this.productRepository.save(product);

        return new SuccessResult(Messages.SuccessMessages.Add);

    }

    @Override
    public Page<Product> findAllWithPagination(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Slice<Product> findAllWithSlice(Pageable pageable) {
        return this.productRepository.getAllWithSlice(pageable);
    }

    private void checkIfCategoryExists(int id){
        Category category = this.categoryService.getById(id).getData();
        if(category==null){
            throw new BusinessException(Messages.Category.CategoryDoesNotExist);
        }
    }


}
