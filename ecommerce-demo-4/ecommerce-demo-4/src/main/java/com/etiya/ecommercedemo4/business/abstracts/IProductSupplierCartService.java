package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.ProductSupplierCart.AddProductSupplierCartRequest;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.ProductSupplierCart;

import java.util.List;

public interface IProductSupplierCartService {

    Result add(AddProductSupplierCartRequest addProductSupplierCartRequest);
    DataResult<List<ProductSupplierCart>> getAll();
}
