package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.IProductSupplierCartService;
import com.etiya.ecommercedemo4.business.dtos.request.ProductSupplierCart.AddProductSupplierCartRequest;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.entities.concretes.ProductSupplierCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productSupplierCarts")
public class ProductSupplierCartsController {

    IProductSupplierCartService productSupplierCartService;

    public ProductSupplierCartsController(IProductSupplierCartService productSupplierCartService) {
        this.productSupplierCartService = productSupplierCartService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody AddProductSupplierCartRequest addProductSupplierCartRequest){
        return this.productSupplierCartService.add(addProductSupplierCartRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<ProductSupplierCart>> getAll(){
        return this.productSupplierCartService.getAll();
    }
    @GetMapping("/getAllWithPagination")
    public Page<ProductSupplierCart> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  this.productSupplierCartService.getAllWithPagination(pageable);
    }
}
