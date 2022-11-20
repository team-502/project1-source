/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author thinhorigami-rio
 */
@Entity
@Table(name = "InvoiceDetail")
@NamedQueries({
    @NamedQuery(name = "InvoiceDetail.findAll", query = "SELECT i FROM InvoiceDetail i"),
    @NamedQuery(name = "InvoiceDetail.findByInvoice", query = "SELECT i FROM InvoiceDetail i WHERE i.invoiceDetailPK.invoice = :invoice"),
    @NamedQuery(name = "InvoiceDetail.findByProductDetail", query = "SELECT i FROM InvoiceDetail i WHERE i.invoiceDetailPK.productDetail = :productDetail"),
    @NamedQuery(name = "InvoiceDetail.findByQuantity", query = "SELECT i FROM InvoiceDetail i WHERE i.quantity = :quantity")})
public class InvoiceDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvoiceDetailPK invoiceDetailPK;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "invoice", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Invoice invoice1;
    @JoinColumn(name = "product_detail", referencedColumnName = "Id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProductDetail productDetail1;

    public InvoiceDetail() {
    }

    public InvoiceDetail(InvoiceDetailPK invoiceDetailPK) {
        this.invoiceDetailPK = invoiceDetailPK;
    }

    public InvoiceDetail(InvoiceDetailPK invoiceDetailPK, int quantity) {
        this.invoiceDetailPK = invoiceDetailPK;
        this.quantity = quantity;
    }

    public InvoiceDetail(String invoice, String productDetail) {
        this.invoiceDetailPK = new InvoiceDetailPK(invoice, productDetail);
    }

    public InvoiceDetailPK getInvoiceDetailPK() {
        return invoiceDetailPK;
    }

    public void setInvoiceDetailPK(InvoiceDetailPK invoiceDetailPK) {
        this.invoiceDetailPK = invoiceDetailPK;
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
        hash += (invoiceDetailPK != null ? invoiceDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceDetail)) {
            return false;
        }
        InvoiceDetail other = (InvoiceDetail) object;
        if ((this.invoiceDetailPK == null && other.invoiceDetailPK != null) || (this.invoiceDetailPK != null && !this.invoiceDetailPK.equals(other.invoiceDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.InvoiceDetail[ invoiceDetailPK=" + invoiceDetailPK + " ]";
    }
    
}
