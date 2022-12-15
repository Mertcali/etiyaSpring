package com.etiya.ecommercedemo4.api.controllers;

import com.etiya.ecommercedemo4.business.abstracts.ICartService;
import com.etiya.ecommercedemo4.business.constants.Paths;
import com.etiya.ecommercedemo4.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemo4.core.util.results.DataResult;
import com.etiya.ecommercedemo4.core.util.results.Result;
import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.entities.concretes.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Paths.apiPrefix +"carts")
public class CartsController {

    private ICartService cartService;

    public CartsController(ICartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Cart>> getAll(){
        return this.cartService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<Cart> getById(@PathVariable int id){
        return this.cartService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid AddCartRequest addCartRequest){
        return this.cartService.add(addCartRequest);
    }
    @GetMapping("/getAllWithPagination")
    public Page<Cart> getAllWithPagination(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        Pageable pageable = PageRequest.of(page,pageSize);
        return  this.cartService.getAllWithPagination(pageable);
    }
}
