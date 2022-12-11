/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.ProductDetail;
import com.project1.model.PromotionDetail;
import java.util.ArrayList;
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
    
    public ArrayList<ProductDetail> getAllNonPromotion() {

        var pp = new PromotionDetailRepository();
        
        var all = getAll();
        
        for (var i : all) {
            if (pp.getByProductDetailId(i.getId()).isPresent()) {
                all.remove(i);
            }
        }
        
        return all;
    }
    
    public ArrayList<ProductDetail> getNonPromotion() {
        
        var sub_q = query().subquery(String.class);
        var sub_r =  sub_q.from(PromotionDetail.class);
        
        sub_q.select(sub_r.get("productDetail"))
                .where(e().equal(root().get("id"), sub_r.get("productDetail")));
        
        return list(query()
                .select(root())
                .where(e().not(e().exists(sub_q))));
    }
}
