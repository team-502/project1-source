/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.ProductDetail;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class ProductDetailReposytory extends Repository<ProductDetail> {

    public ProductDetailReposytory() {
        super(ProductDetail.class);
    }
    
    public Optional<ProductDetail> getById(String id) {
        var find = e().equal(root().get("id"), id);
        
        return single(
             query()
             .select(root())
             .where(find));
    }
}
