package com.etiya.ecommercedemo4.repository;

import com.etiya.ecommercedemo4.entities.concretes.City;
import com.etiya.ecommercedemo4.entities.concretes.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICityRepository extends JpaRepository<City,Integer> {


}
