package com.etiya.ecommercedemo4.repository;

import com.etiya.ecommercedemo4.business.dtos.response.category.GetAllCategoriesWithProductResponse;
import com.etiya.ecommercedemo4.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {

    @Query("select c from Category c inner join " +
            "c.productCategories pc inner join pc.product p where c.id = :categoryId")
    List<Category> denemeEndPoint(int categoryId);

    @Query("select new com.etiya.ecommercedemo4.business.dtos.response.category.GetAllCategoriesWithProductResponse" +
            "(c.id, c.name, p.name) from Category c inner join " +
            "c.productCategories pc inner join pc.product p where c.id = :categoryId")
    List<GetAllCategoriesWithProductResponse> denemeEndPoint2(int categoryId);

    boolean existsCategoryByNameIgnoreCase(String name);

}
