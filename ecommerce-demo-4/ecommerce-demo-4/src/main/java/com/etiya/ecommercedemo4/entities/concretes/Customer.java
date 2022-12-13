package com.etiya.ecommercedemo4.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
public class Customer extends User{


    @Column(name = "customer_number")
    private String customerNumber;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToOne(mappedBy = "customer")
    @JsonIgnore
    private Cart cart;

}
