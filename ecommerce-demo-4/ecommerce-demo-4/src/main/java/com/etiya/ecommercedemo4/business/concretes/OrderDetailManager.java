package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IOrderDetailService;
import com.etiya.ecommercedemo4.business.abstracts.IProductSuppliersService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.orderDetails.AddOrderDetailRequest;
import com.etiya.ecommercedemo4.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.messages.IMessagesService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessResult;
import com.etiya.ecommercedemo4.entities.concretes.OrderDetail;
import com.etiya.ecommercedemo4.entities.concretes.ProductSuppliers;
import com.etiya.ecommercedemo4.repository.IOrderDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderDetailManager implements IOrderDetailService {

    private IOrderDetailRepository orderDetailRepository;
    private ModelMapperService modelMapperService;
    private IProductSuppliersService productSuppliersService;

    private IMessagesService messagesService;


    @Override
    public Result add(AddOrderDetailRequest addOrderDetailRequest) {
        checkIfProductSupplierExists(addOrderDetailRequest.getProductSuppliersId());
        OrderDetail orderDetail = this.modelMapperService.forRequest().map(addOrderDetailRequest,OrderDetail.class);
        //TODO: Total_price_düzelticek.
        orderDetail.setId(0);
        orderDetail.setTotalPrice(100);
        this.orderDetailRepository.save(orderDetail);
        return new SuccessResult(messagesService.getMessage(Messages.SuccessMessages.Add));
    }
    @Override
    public DataResult<List<OrderDetail>> getAll() {
        List<OrderDetail> response = this.orderDetailRepository.findAll();
        return new SuccessDataResult<List<OrderDetail>>(response,messagesService.getMessage(Messages.SuccessMessages.ListAll));
    }

    @Override
    public DataResult<OrderDetail> getById(int id) {
        OrderDetail response = this.orderDetailRepository.findById(id).orElseThrow();
        return new SuccessDataResult<OrderDetail>(response,messagesService.getMessage(Messages.SuccessMessages.ListById));
    }

    @Override
    public Page<OrderDetail> getAllWithPagination(Pageable pageable) {
        return this.orderDetailRepository.findAll(pageable);
    }

    private void checkIfProductSupplierExists(int id){
        DataResult<ProductSuppliers> productSupplier= this.productSuppliersService.getById(id);
        if(productSupplier==null){
            throw new BusinessException(messagesService.getMessage(Messages.ProductSupplier.ProductSupplierDoesNotExist));
        }
    }

}
