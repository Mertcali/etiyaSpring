package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IProductSupplierCartService;
import com.etiya.ecommercedemo4.business.abstracts.IProductSuppliersService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.ProductSupplierCart.AddProductSupplierCartRequest;
import com.etiya.ecommercedemo4.business.dtos.request.productSuppliers.AddProductSuppliersRequest;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.messages.IMessagesService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessResult;
import com.etiya.ecommercedemo4.entities.concretes.ProductSupplierCart;
import com.etiya.ecommercedemo4.entities.concretes.ProductSuppliers;
import com.etiya.ecommercedemo4.repository.IProductSupplierCartRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductSupplierCartManager implements IProductSupplierCartService {

    private IProductSupplierCartRepository productSupplierCartRepository;
    private ModelMapperService modelMapperService;

    private IMessagesService messagesService;

    @Override
    public Result add(AddProductSupplierCartRequest addProductSupplierCartRequest) {
        ProductSupplierCart productSupplierCart = this.modelMapperService.forRequest().map(addProductSupplierCartRequest,ProductSupplierCart.class);
        productSupplierCart.setId(0);
        this.productSupplierCartRepository.save(productSupplierCart);
        return new SuccessResult(messagesService.getMessage(Messages.SuccessMessages.Add));
    }

    @Override
    public Page<ProductSupplierCart> getAllWithPagination(Pageable pageable) {
        return this.productSupplierCartRepository.findAll(pageable);
    }

    @Override
    public DataResult<List<ProductSupplierCart>> getAll() {
        List<ProductSupplierCart> response = this.productSupplierCartRepository.findAll();
        return new SuccessDataResult<List<ProductSupplierCart>>(response,messagesService.getMessage(Messages.SuccessMessages.ListAll));
    }
}



