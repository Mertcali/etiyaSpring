package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.productSuppliers.AddProductSuppliersRequest;
import com.etiya.ecommercedemo4.business.dtos.response.productSuppliers.AddProductSuppliersResponse;
import com.etiya.ecommercedemo4.business.dtos.response.supplier.AddSupplierResponse;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import com.etiya.ecommercedemo4.entities.concretes.ProductSuppliers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductSuppliersService {

    Result add(AddProductSuppliersRequest addProductSuppliersRequest);
    DataResult<List<ProductSuppliers>> getAll();

    DataResult<ProductSuppliers> getById(int id);
    Page<ProductSuppliers> getAllWithPagination(Pageable pageable);

}
