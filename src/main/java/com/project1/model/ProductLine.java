/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

/**
 *
 * @author thinhorigami-rio
 */
@Entity
@Table(name = "ProductLine")
@NamedQueries({
    @NamedQuery(name = "ProductLine.findAll", query = "SELECT p FROM ProductLine p"),
    @NamedQuery(name = "ProductLine.findById", query = "SELECT p FROM ProductLine p WHERE p.id = :id"),
    @NamedQuery(name = "ProductLine.findByIdProductLine", query = "SELECT p FROM ProductLine p WHERE p.idProductLine = :idProductLine"),
    @NamedQuery(name = "ProductLine.findByName", query = "SELECT p FROM ProductLine p WHERE p.name = :name")})
public class ProductLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue
    @UuidGenerator
    private String id;
    @Column(name = "id_product_line")
    private String idProductLine;
    @Column(name = "_name")
    private String name;
    @OneToMany(mappedBy = "productLine")
    private Collection<ProductDetail> productDetailCollection;

    public ProductLine() {
    }

    public ProductLine(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProductLine() {
        return idProductLine;
    }

    public void setIdProductLine(String idProductLine) {
        this.idProductLine = idProductLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<ProductDetail> getProductDetailCollection() {
        return productDetailCollection;
    }

    public void setProductDetailCollection(Collection<ProductDetail> productDetailCollection) {
        this.productDetailCollection = productDetailCollection;
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
        if (!(object instanceof ProductLine)) {
            return false;
        }
        ProductLine other = (ProductLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.ProductLine[ id=" + id + " ]";
    }
    
}
