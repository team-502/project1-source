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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Invoice")
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id"),
    @NamedQuery(name = "Invoice.findByCreatedDate", query = "SELECT i FROM Invoice i WHERE i.createdDate = :createdDate"),
    @NamedQuery(name = "Invoice.findByPaymentDate", query = "SELECT i FROM Invoice i WHERE i.paymentDate = :paymentDate"),
    @NamedQuery(name = "Invoice.findByReceivedDate", query = "SELECT i FROM Invoice i WHERE i.receivedDate = :receivedDate"),
    @NamedQuery(name = "Invoice.findByState", query = "SELECT i FROM Invoice i WHERE i.state = :state"),
    @NamedQuery(name = "Invoice.findByPaymentMethod", query = "SELECT i FROM Invoice i WHERE i.paymentMethod = :paymentMethod")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @Basic(optional = false)
    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    @Basic(optional = false)
    @Column(name = "_state")
    private int state;
    @Basic(optional = false)
    @Column(name = "payment_method")
    private int paymentMethod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice1")
    private Collection<InvoiceDetail> invoiceDetailCollection;
    @JoinColumn(name = "customer", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "staff", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Staff staff;

    public Invoice() {
    }

    public Invoice(String id) {
        this.id = id;
    }

    public Invoice(String id, Date createdDate, Date paymentDate, Date receivedDate, int state, int paymentMethod) {
        this.id = id;
        this.createdDate = createdDate;
        this.paymentDate = paymentDate;
        this.receivedDate = receivedDate;
        this.state = state;
        this.paymentMethod = paymentMethod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Collection<InvoiceDetail> getInvoiceDetailCollection() {
        return invoiceDetailCollection;
    }

    public void setInvoiceDetailCollection(Collection<InvoiceDetail> invoiceDetailCollection) {
        this.invoiceDetailCollection = invoiceDetailCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.Invoice[ id=" + id + " ]";
    }
    
}
