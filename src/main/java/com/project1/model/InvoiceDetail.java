/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model;

import java.io.Serializable;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;

/**
 *
 * @author thinhorigami-rio
 */
@Entity
@Table(name = "InvoiceDetail")
public class InvoiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    
    @JoinColumn(name = "invoice", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Invoice invoice1;

    @JoinColumn(name = "product_detail", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private ProductDetail productDetail1;

    public InvoiceDetail() {
    }

    public String getId() {
        return this.id;
    }

    public void setInvoiceDetailPK(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Invoice getInvoice1() {
        return invoice1;
    }

    public void setInvoice1(Invoice invoice1) {
        this.invoice1 = invoice1;
    }

    public ProductDetail getProductDetail1() {
        return productDetail1;
    }

    public void setProductDetail1(ProductDetail productDetail1) {
        this.productDetail1 = productDetail1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceDetail)) {
            return false;
        }
        InvoiceDetail other = (InvoiceDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.InvoiceDetail[ invoiceDetailPK=" + id + " ]";
    }
    
}
