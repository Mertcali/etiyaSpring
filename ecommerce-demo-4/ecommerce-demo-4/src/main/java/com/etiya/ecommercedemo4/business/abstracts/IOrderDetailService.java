package com.etiya.ecommercedemo4.business.abstracts;

import com.etiya.ecommercedemo4.business.dtos.request.orderDetails.AddOrderDetailRequest;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.AddressType;
import com.etiya.ecommercedemo4.entities.concretes.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderDetailService {
    DataResult<List<OrderDetail>> getAll();
    DataResult<OrderDetail> getById(int id);
    Result add(AddOrderDetailRequest addOrderDetailRequest);
    Page<OrderDetail> getAllWithPagination(Pageable pageable);
}
