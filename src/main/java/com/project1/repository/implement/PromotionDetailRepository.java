/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.PromotionDetail;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class PromotionDetailRepository extends Repository<PromotionDetail> {
    
    public PromotionDetailRepository() {
        super(PromotionDetail.class);
    }
    
    public Optional<PromotionDetail> getByProductDetailId(String id) {
        
        var join_pd = root().join("productDetail");
        
        var confition = e().equal(root().get("id"), id);
        
        return single(query().select(root()).where(confition));
        
    }
    
}
