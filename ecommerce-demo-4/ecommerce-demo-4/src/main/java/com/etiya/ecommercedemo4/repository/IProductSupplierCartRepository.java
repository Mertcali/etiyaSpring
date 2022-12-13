package com.etiya.ecommercedemo4.repository;

import com.etiya.ecommercedemo4.entities.concretes.ProductSupplierCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductSupplierCartRepository extends JpaRepository<ProductSupplierCart,Integer> {
}
