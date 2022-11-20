/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author thinhorigami-rio
 */
@Entity
@Table(name = "staff")
@NamedQueries({
    @NamedQuery(name = "Staff_1.findAll", query = "SELECT s FROM Staff_1 s"),
    @NamedQuery(name = "Staff_1.findById", query = "SELECT s FROM Staff_1 s WHERE s.id = :id"),
    @NamedQuery(name = "Staff_1.findByIdStaff", query = "SELECT s FROM Staff_1 s WHERE s.idStaff = :idStaff"),
    @NamedQuery(name = "Staff_1.findByFullName", query = "SELECT s FROM Staff_1 s WHERE s.fullName = :fullName"),
    @NamedQuery(name = "Staff_1.findByGender", query = "SELECT s FROM Staff_1 s WHERE s.gender = :gender"),
    @NamedQuery(name = "Staff_1.findByEmai", query = "SELECT s FROM Staff_1 s WHERE s.emai = :emai"),
    @NamedQuery(name = "Staff_1.findByBirth", query = "SELECT s FROM Staff_1 s WHERE s.birth = :birth"),
    @NamedQuery(name = "Staff_1.findByAddress", query = "SELECT s FROM Staff_1 s WHERE s.address = :address"),
    @NamedQuery(name = "Staff_1.findByPassword", query = "SELECT s FROM Staff_1 s WHERE s.password = :password"),
    @NamedQuery(name = "Staff_1.findByPhoneNumber", query = "SELECT s FROM Staff_1 s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Staff_1.findByState", query = "SELECT s FROM Staff_1 s WHERE s.state = :state")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Basic(optional = false)
    @Column(name = "id_staff")
    private String idStaff;
    @Basic(optional = false)
    @Column(name = "full_name")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "emai")
    private String emai;
    @Basic(optional = false)
    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;
    @Basic(optional = false)
    @Column(name = "_address")
    private String address;
    @Basic(optional = false)
    @Column(name = "_password")
    private String password;
    @Basic(optional = false)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "_state")
    private int state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staff")
    private Collection<Invoice> invoiceCollection;

    public Staff() {
    }

    public Staff(String id) {
        this.id = id;
    }

    public Staff(String id, String idStaff, String fullName, String gender, String emai, Date birth, String address, String password, String phoneNumber, int state) {
        this.id = id;
        this.idStaff = idStaff;
        this.fullName = fullName;
        this.gender = gender;
        this.emai = emai;
        this.birth = birth;
        this.address = address;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
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
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.Staff_1[ id=" + id + " ]";
    }
    
}
