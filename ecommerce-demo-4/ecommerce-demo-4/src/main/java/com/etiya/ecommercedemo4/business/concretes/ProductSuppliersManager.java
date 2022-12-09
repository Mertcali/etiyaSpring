package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IProductSuppliersService;
import com.etiya.ecommercedemo4.business.dtos.request.productSuppliers.AddProductSuppliersRequest;
import com.etiya.ecommercedemo4.business.dtos.response.productSuppliers.AddProductSuppliersResponse;
import com.etiya.ecommercedemo4.business.dtos.response.supplier.AddSupplierResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.ProductSuppliers;
import com.etiya.ecommercedemo4.repository.IProductSuppliersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSuppliersManager implements IProductSuppliersService {

    private IProductSuppliersRepository productSuppliersRepository;
    private ModelMapperService modelMapperService;


    public ProductSuppliersManager(IProductSuppliersRepository productSuppliersRepository, ModelMapperService modelMapperService) {
        this.productSuppliersRepository = productSuppliersRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<ProductSuppliers> getAll() {
        return this.productSuppliersRepository.findAll();
    }

    @Override
    public AddProductSuppliersResponse add(AddProductSuppliersRequest addProductSuppliersRequest) {

        ProductSuppliers productSuppliers = this.modelMapperService.forRequest().map(addProductSuppliersRequest,ProductSuppliers.class);

        ProductSuppliers savedProductSuppliers = this.productSuppliersRepository.save(productSuppliers);

        AddProductSuppliersResponse response = this.modelMapperService.forResponse().map(savedProductSuppliers,AddProductSuppliersResponse.class);
        return response;

    }
}
