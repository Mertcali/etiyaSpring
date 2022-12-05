package com.etiya.ecommercedemo4.repository;

import com.etiya.ecommercedemo4.entities.concretes.Address;
import com.etiya.ecommercedemo4.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address,Integer> {

    //join denenecek.Burası tamamlanmadı. Endpointi oluşturuldu. Where condition denenebilir.
    @Query("Select a from Address a JOIN a.addressType")
    List<Address> findByAddressType();
    @Query("Select p from Product as p WHERE name = :name")
    Product findByName(String name);
}
