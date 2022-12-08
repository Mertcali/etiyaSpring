package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ISupplierService;
import com.etiya.ecommercedemo4.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemo4.business.dtos.response.supplier.AddSupplierResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.entities.concretes.Supplier;
import com.etiya.ecommercedemo4.repository.ISupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierManager implements ISupplierService {

    private ISupplierRepository supplierRepository;
    private ModelMapperService modelMapperService;

    public SupplierManager(ISupplierRepository supplierRepository, ModelMapperService modelMapperService) {
        this.supplierRepository = supplierRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<Supplier> getAll() {
        return this.supplierRepository.findAll();
    }

    @Override
    public AddSupplierResponse add(AddSupplierRequest addSupplierRequest) {

        Supplier supplier = this.modelMapperService.forRequest().map(addSupplierRequest,Supplier.class);

        Supplier savedSupplier = this.supplierRepository.save(supplier);

        AddSupplierResponse response = this.modelMapperService.forResponse().map(savedSupplier,AddSupplierResponse.class);

        return response;
    }
}
