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
@Table(name = "carts")

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @OneToOne
    @JoinColumn(name = "customer_id")
   // @JsonIgnoreProperties("cart")
    @JsonIgnore
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    private List<ProductSupplierCart> productSupplierCarts;


}
