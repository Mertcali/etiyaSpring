package com.etiya.ecommercedemo4.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "suppliers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
public class Supplier extends User{


    @Column(name = "supplier_number")
    private String supplierNumber;


    @OneToMany(mappedBy = "supplier")
   // @JsonIgnoreProperties("supplier")
    @JsonIgnore
    private List<ProductSuppliers> productSuppliers;

}
