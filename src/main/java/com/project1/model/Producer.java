/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

/**
 *
 * @author thinhorigami-rio
 */
@Entity
@Table(name = "producer")
@NamedQueries({
    @NamedQuery(name = "Producer.findAll", query = "SELECT p FROM Producer p"),
    @NamedQuery(name = "Producer.findById", query = "SELECT p FROM Producer p WHERE p.id = :id"),
    @NamedQuery(name = "Producer.findByIdProducer", query = "SELECT p FROM Producer p WHERE p.idProducer = :idProducer"),
    @NamedQuery(name = "Producer.findByName", query = "SELECT p FROM Producer p WHERE p.name = :name")})
public class Producer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    @GeneratedValue
    @UuidGenerator
    private String id;
    @Column(name = "id_producer")
    private String idProducer;
    @Column(name = "_name")
    private String name;
    @OneToMany(mappedBy = "producer")
    private Collection<ProductDetail> productDetailCollection;

    public Producer() {
    }

    public Producer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(String idProducer) {
        this.idProducer = idProducer;
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
        if (!(object instanceof Producer)) {
            return false;
        }
        Producer other = (Producer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.Producer[ id=" + id + " ]";
    }
    
}
