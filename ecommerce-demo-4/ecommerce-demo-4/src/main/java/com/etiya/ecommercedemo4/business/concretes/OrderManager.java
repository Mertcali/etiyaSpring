package com.etiya.ecommercedemo4.business.concretes;

import com.etiya.ecommercedemo4.business.abstracts.IOrderService;
import com.etiya.ecommercedemo4.business.abstracts.IPaymentService;
import com.etiya.ecommercedemo4.business.constants.Messages;
import com.etiya.ecommercedemo4.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo4.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo4.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.core.util.results.SuccessDataResult;
import com.etiya.ecommercedemo4.core.util.results.SuccessResult;
import com.etiya.ecommercedemo4.entities.concretes.Order;
import com.etiya.ecommercedemo4.entities.concretes.Payment;
import com.etiya.ecommercedemo4.repository.IOrderRepository;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class OrderManager implements IOrderService {

    private IOrderRepository orderRepository;
    private ModelMapperService modelMapperService;
    private IPaymentService paymentService;

    //TODO : ADD
    @Override
    public DataResult<List<Order>> getAll() {
        List<Order> response = this.orderRepository.findAll();
        return new SuccessDataResult<List<Order>>(response, Messages.SuccessMessages.ListAll);
    }

    @Override
    public DataResult<Order> getById(int id) {
        Order response = this.orderRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Order>(response,Messages.SuccessMessages.ListById);
    }

    @Override
    public Result add(AddOrderRequest addOrderRequest) {
        checkIfPaymentExists(addOrderRequest.getPaymentId());
        Order order = this.modelMapperService.forRequest().map(addOrderRequest,Order.class);
        order.setId(0);
        Date date = new Date();
        order.setOrderDate(date);
        this.orderRepository.save(order);
        return new SuccessResult(Messages.SuccessMessages.Add);
    }

    private void checkIfPaymentExists(int id){

        DataResult<Payment> payment = this.paymentService.getById(id);
        if(payment==null){
            throw new BusinessException(Messages.Order.OrderDoesNotExist);
        }
    }
}
