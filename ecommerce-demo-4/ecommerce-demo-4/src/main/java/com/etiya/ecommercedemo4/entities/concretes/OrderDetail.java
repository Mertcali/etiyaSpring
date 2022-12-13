package com.etiya.ecommercedemo4.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "total_price")
    private double totalPrice;



    @OneToMany(mappedBy = "orderDetail")
  //  @JsonIgnoreProperties("orderDetail")
    @JsonIgnore
    private List<Order> orders;

    @OneToOne
    @JoinColumn(name = "product_supplier_cart_id")
    @JsonIgnore
    private ProductSupplierCart productSupplierCart;
}
