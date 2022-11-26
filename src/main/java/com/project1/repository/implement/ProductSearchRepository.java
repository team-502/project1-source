/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.Color;
import com.project1.model.Producer;
import com.project1.model.ProductDetail;
import com.project1.model.ProductLine;
import jakarta.persistence.criteria.Predicate;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author thinhorigami-rio
 */
public class ProductSearchRepository extends Repository<ProductDetail>{
    
    private ArrayList<Predicate> cond; // conditions
    
    public ProductSearchRepository() {
        super(ProductDetail.class);
        cond = new ArrayList<>();
    }
    
    public void setName(String name) {
        
        var product = root().join("product");
        
        cond.add(e().like(product.get("name"), name));
    }
    
    public void setIdProduct(String id) {
        
        var product = root().join("product");
        
        cond.add(e().like(product.get("idProduct"), id));
    }    
    
    public void setColor(Color color) {
        
        cond.add(e().equal(root().get("color"), color));
    }
    
    public void setProducer(Producer p) {
        
        cond.add(e().equal(root().get("producer"), p));
    }
    
    public void setProductLine(ProductLine p) {
        
        cond.add(e().equal(root().get("productLine"), p));
    }
    
    public void setSize(int min, int max) {
        
        var g = e().greaterThanOrEqualTo(root().get("size"), min);
        var l = e().lessThanOrEqualTo(root().get("size"), max);
        
        cond.add(e().and(g, l));
    }
    
    public void setQuantity(int min, int max) {
        
        var g = e().greaterThanOrEqualTo(root().get("quantity"), min);
        var l = e().lessThanOrEqualTo(root().get("quantity"), max);
        
        cond.add(e().and(g, l));
    }
    
    public void setImportPrice(BigInteger min, BigInteger max) {
        
        var g = e().greaterThanOrEqualTo(root().get("importPrice"), min);
        var l = e().lessThanOrEqualTo(root().get("importPrice"), max);
        
        cond.add(e().and(g, l));
    }
    
    public void setExportPrice(BigInteger min, BigInteger max) {
        
        var g = e().greaterThanOrEqualTo(root().get("exportPrice"), min);
        var l = e().lessThanOrEqualTo(root().get("emportPrice"), max);
        
        cond.add(e().and(g, l));
    }
    
    public ArrayList<ProductDetail> getResult() {
        System.out.println("\nsearch query\n");
        return list(query()
                .select(root())
               .where(e().and(this.cond.toArray(new Predicate[] {}))));
    }
}
