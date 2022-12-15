package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IProductSuppliersService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.productSuppliers.AddProductSuppliersRequest;
import com.etiya.ecommercedemo4.business.dtos.response.productSuppliers.AddProductSuppliersResponse;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.messages.IMessagesService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessResult;
import com.etiya.ecommercedemo4.entities.concretes.ProductSuppliers;
import com.etiya.ecommercedemo4.repository.IProductSuppliersRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductSuppliersManager implements IProductSuppliersService {

    private IProductSuppliersRepository productSuppliersRepository;
    private ModelMapperService modelMapperService;
    private IMessagesService messagesService;



    @Override
    public DataResult<List<ProductSuppliers>> getAll() {
        List<ProductSuppliers> response = this.productSuppliersRepository.findAll();

        return new SuccessDataResult<List<ProductSuppliers>>(response,messagesService.getMessage( Messages.SuccessMessages.ListAll));
    }

    @Override
    public Page<ProductSuppliers> getAllWithPagination(Pageable pageable) {
        return this.productSuppliersRepository.findAll(pageable);
    }

    @Override
    public Result add(AddProductSuppliersRequest addProductSuppliersRequest) {

        ProductSuppliers productSuppliers = this.modelMapperService.forRequest().map(addProductSuppliersRequest,ProductSuppliers.class);
        productSuppliers.setId(0);
        this.productSuppliersRepository.save(productSuppliers);
        return new SuccessResult(messagesService.getMessage(Messages.SuccessMessages.Add));

    }

    @Override
    public DataResult<ProductSuppliers> getById(int id) {
        ProductSuppliers response =this.productSuppliersRepository.findById(id).orElseThrow();
        return new SuccessDataResult<ProductSuppliers>(response,messagesService.getMessage(Messages.SuccessMessages.Add));
    }
}
