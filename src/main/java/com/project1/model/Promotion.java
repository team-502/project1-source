/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model;

import jakarta.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

/**
 *
 * @author thinhorigami-rio
 */
@Entity
@Table(name = "Promotion")
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue
    @UuidGenerator
    private String id;
    @Column(name = "_name")
    private String name;
    @Basic(optional = false)
    @Column(name = "state_date")
    @Temporal(TemporalType.DATE)
    private Date stateDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "_percent")
    private int percent;
    @Basic(optional = false)
    @Column(name = "_money")
    private long money;
    @Basic(optional = false)
    @Column(name = "_type")
    private boolean type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
    private Collection<PromotionDetail> promotionDetailCollection;

    public Promotion() {
    }

    public Promotion(String id) {
        this.id = id;
    }

    public Promotion(String id, Date stateDate, Date endDate, int percent, long money, boolean type) {
        this.id = id;
        this.stateDate = stateDate;
        this.endDate = endDate;
        this.percent = percent;
        this.money = money;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStateDate() {
        return stateDate;
    }

    public void setStateDate(Date stateDate) {
        this.stateDate = stateDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public Collection<PromotionDetail> getPromotionDetailCollection() {
        return promotionDetailCollection;
    }

    public void setPromotionDetailCollection(Collection<PromotionDetail> promotionDetailCollection) {
        this.promotionDetailCollection = promotionDetailCollection;
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
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.Promotion[ id=" + id + " ]";
    }
    
}
