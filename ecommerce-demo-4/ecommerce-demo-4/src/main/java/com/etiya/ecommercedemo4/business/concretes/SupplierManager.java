package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.ISupplierService;
import com.etiya.ecommercedemo4.business.abstracts.IUserService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemo4.business.dtos.response.supplier.AddSupplierResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.messages.IMessagesService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessResult;
import com.etiya.ecommercedemo4.entities.concretes.Supplier;
import com.etiya.ecommercedemo4.repository.ISupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierManager implements ISupplierService {

    private ISupplierRepository supplierRepository;
    private ModelMapperService modelMapperService;

    private IUserService userService;

    private IMessagesService messagesService;


    @Override
    public DataResult<List<Supplier>> getAll() {
        List<Supplier> response = this.supplierRepository.findAll();
        return new SuccessDataResult<List<Supplier>>(response,messagesService.getMessage(Messages.SuccessMessages.ListAll));
    }

    @Override
    public Page<Supplier> getAllWithPagination(Pageable pageable) {
        return this.supplierRepository.findAll(pageable);
    }

    @Override
    public Result add(AddSupplierRequest addSupplierRequest) {
        Supplier supplier = this.modelMapperService.forRequest().map(addSupplierRequest,Supplier.class);

        supplier.setId(0);
        supplier.setName("Mert");
        this.supplierRepository.save(supplier);

        return new SuccessResult(messagesService.getMessage(Messages.SuccessMessages.Add));
    }
}
