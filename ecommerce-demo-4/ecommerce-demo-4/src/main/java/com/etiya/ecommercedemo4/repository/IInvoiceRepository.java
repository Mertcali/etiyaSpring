package com.etiya.ecommercedemo4.repository;

import com.etiya.ecommercedemo4.business.dtos.response.invoices.GetInvoiceDto;
import com.etiya.ecommercedemo4.entities.concretes.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IInvoiceRepository extends JpaRepository<Invoice,Integer> {

    Invoice findByInvoiceNumber(String invoiceNumber);



    @Query("select new com.etiya.ecommercedemo4.business.dtos.response.invoices.GetInvoiceDto" +
            "(inv.id, inv.invoiceNumber, pa.description, pat.name, c.quantity, " +
            "pro.name, pro.unitPrice, cat.name,su.name, su.email, cu.name, " +
            "str.name, dist.name, to.name, ci.name, cou.name) " +
            "from Invoice inv " +
            "inner join inv.order orde inner join orde.payment pa inner join pa.paymentType pat inner join orde.orderDetail ord " +
            "inner join ord.productSupplierCart psc inner join psc.cart c inner join c.customer cu inner join psc.productSuppliers ps " +
            "inner join ps.product pro inner join ps.supplier su inner join pro.productCategories proc inner join proc.category cat " +
            "inner join cu.addresses add inner join add.street str inner join str.district dist inner join dist.town to inner join to.city ci " +
            "inner join ci.country cou where inv.id =:id")
    GetInvoiceDto getInvoiceDto(int id);


    /*
    @Query("select new com.etiya.ecommercedemo4.business.dtos.response.invoices.GetInvoiceDto" +
            "(inv.id, inv.invoiceNumber, pa.description) " +
            "from Invoice inv " +
            "inner join inv.order orde inner join orde.payment pa inner join pa.paymentType pat inner join orde.orderDetail ord " +
            "inner join ord.productSupplierCart psc inner join psc.cart c inner join c.customer cu inner join psc.productSuppliers ps " +
            "inner join ps.product pro inner join ps.supplier su  where inv.id =:id")
    GetInvoiceDto getInvoiceDto(int id);

     */
}
