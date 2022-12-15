package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemo4.business.dtos.response.supplier.AddSupplierResponse;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import com.etiya.ecommercedemo4.entities.concretes.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISupplierService {
    Result add(AddSupplierRequest addSupplierRequest);
    DataResult<List<Supplier>> getAll();
    Page<Supplier> getAllWithPagination(Pageable pageable);


}
