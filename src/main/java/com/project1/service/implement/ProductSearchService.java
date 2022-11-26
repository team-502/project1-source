/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.service.implement;

import com.project1.model.ProductDetail;
import com.project1.repository.implement.ProductSearchRepository;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

/**
 *
 * @author thinhorigami-rio
 */
public class ProductSearchService {
    
    private ProductSearchRepository psr;
    private ArrayList<Predicate> cond; // conditions;
    public ProductSearchService() {
        psr = new ProductSearchRepository();
        cond = new ArrayList<Predicate>();
    }
    
   public ArrayList<ProductDetail> ge() {
       return psr.getResult();
   }
} 
