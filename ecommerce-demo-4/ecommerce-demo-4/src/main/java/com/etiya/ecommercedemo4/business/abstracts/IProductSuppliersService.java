package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.productSuppliers.AddProductSuppliersRequest;
import com.etiya.ecommercedemo4.business.dtos.response.productSuppliers.AddProductSuppliersResponse;
import com.etiya.ecommercedemo4.business.dtos.response.supplier.AddSupplierResponse;
import com.etiya.ecommercedemo4.entities.concretes.ProductSuppliers;

import java.util.List;

public interface IProductSuppliersService {

    List<ProductSuppliers> getAll();
    AddProductSuppliersResponse add(AddProductSuppliersRequest addProductSuppliersRequest);

}
