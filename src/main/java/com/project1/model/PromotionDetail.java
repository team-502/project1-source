/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

/**
 *
 * @author thinhorigami-rio
 */
@Entity
@Table(name = "PromotionDetail")
@NamedQueries({
    @NamedQuery(name = "PromotionDetail.findAll", query = "SELECT p FROM PromotionDetail p"),
    @NamedQuery(name = "PromotionDetail.findById", query = "SELECT p FROM PromotionDetail p WHERE p.id = :id")})
public class PromotionDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue
    @UuidGenerator
    private String id;
    @JoinColumn(name = "product_detail", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private ProductDetail productDetail;
    @JoinColumn(name = "Promotion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Promotion promotion;

    public PromotionDetail() {
    }

    public PromotionDetail(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
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
        if (!(object instanceof PromotionDetail)) {
            return false;
        }
        PromotionDetail other = (PromotionDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.PromotionDetail[ id=" + id + " ]";
    }
    
}
