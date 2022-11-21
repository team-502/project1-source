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
@Embeddable
public class InvoiceDetailPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "invoice")
    private String invoice;
    @Basic(optional = false)
    @Column(name = "product_detail")
    private String productDetail;

    public InvoiceDetailPK() {
    }

    public InvoiceDetailPK(String invoice, String productDetail) {
        this.invoice = invoice;
        this.productDetail = productDetail;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoice != null ? invoice.hashCode() : 0);
        hash += (productDetail != null ? productDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceDetailPK)) {
            return false;
        }
        InvoiceDetailPK other = (InvoiceDetailPK) object;
        if ((this.invoice == null && other.invoice != null) || (this.invoice != null && !this.invoice.equals(other.invoice))) {
            return false;
        }
        if ((this.productDetail == null && other.productDetail != null) || (this.productDetail != null && !this.productDetail.equals(other.productDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.InvoiceDetailPK[ invoice=" + invoice + ", productDetail=" + productDetail + " ]";
    }
    
}
