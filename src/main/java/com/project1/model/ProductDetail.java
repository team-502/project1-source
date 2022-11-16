/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author thinhorigami-rio
 */
@Entity
@Table(name = "ProductDetail")
@NamedQueries({
    @NamedQuery(name = "ProductDetail.findAll", query = "SELECT p FROM ProductDetail p"),
    @NamedQuery(name = "ProductDetail.findById", query = "SELECT p FROM ProductDetail p WHERE p.id = :id"),
    @NamedQuery(name = "ProductDetail.findBySize", query = "SELECT p FROM ProductDetail p WHERE p.size = :size"),
    @NamedQuery(name = "ProductDetail.findByQuantity", query = "SELECT p FROM ProductDetail p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "ProductDetail.findByDecription", query = "SELECT p FROM ProductDetail p WHERE p.decription = :decription"),
    @NamedQuery(name = "ProductDetail.findByImportPrice", query = "SELECT p FROM ProductDetail p WHERE p.importPrice = :importPrice"),
    @NamedQuery(name = "ProductDetail.findByExportPrice", query = "SELECT p FROM ProductDetail p WHERE p.exportPrice = :exportPrice")})
public class ProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private String id;
    @Column(name = "Size")
    private Integer size;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "decription")
    private String decription;
    @Column(name = "import_price")
    private BigInteger importPrice;
    @Column(name = "export_price")
    private BigInteger exportPrice;
    @ManyToMany(mappedBy = "productDetailCollection")
    private Collection<Promotion> promotionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productDetail")
    private Collection<InvoiceDetail> invoiceDetailCollection;
    @JoinColumn(name = "color", referencedColumnName = "Id")
    @ManyToOne
    private Color color;
    @JoinColumn(name = "producer", referencedColumnName = "Id")
    @ManyToOne
    private Producer producer;
    @JoinColumn(name = "product", referencedColumnName = "Id")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "product_line", referencedColumnName = "Id")
    @ManyToOne
    private ProductLine productLine;

    public ProductDetail() {
    }

    public ProductDetail(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public BigInteger getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(BigInteger importPrice) {
        this.importPrice = importPrice;
    }

    public BigInteger getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(BigInteger exportPrice) {
        this.exportPrice = exportPrice;
    }

    public Collection<Promotion> getPromotionCollection() {
        return promotionCollection;
    }

    public void setPromotionCollection(Collection<Promotion> promotionCollection) {
        this.promotionCollection = promotionCollection;
    }

    public Collection<InvoiceDetail> getInvoiceDetailCollection() {
        return invoiceDetailCollection;
    }

    public void setInvoiceDetailCollection(Collection<InvoiceDetail> invoiceDetailCollection) {
        this.invoiceDetailCollection = invoiceDetailCollection;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
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
        if (!(object instanceof ProductDetail)) {
            return false;
        }
        ProductDetail other = (ProductDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project1.model.ProductDetail[ id=" + id + " ]";
    }
    
}
