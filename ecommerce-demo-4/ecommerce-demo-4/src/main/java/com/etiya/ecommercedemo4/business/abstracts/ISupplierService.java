package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemo4.business.dtos.response.supplier.AddSupplierResponse;
import com.etiya.ecommercedemo4.entities.concretes.Supplier;

import java.util.List;

public interface ISupplierService {

    List<Supplier> getAll();

    AddSupplierResponse add(AddSupplierRequest addSupplierRequest);
}
