/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.utility.dataset;

import com.project1.repository.implement.*;

/**
 *
 * @author thinhorigami-rio
 */
public class DataSet {
    private StaffRepository staff;
    private CustomerRepository customer;
    
    private InvoiceRepository invoice;
    private InvoicedetailRepository invoice_detail;
    
    private ProductRepository product;
    private ProductLineRepository product_line;
    private ProducerRepository producer;
    private ColorRepository color;
    private ProductDetailReposytory product_detail;
    
    private PromotionRepository promotion;
    private PromotionDetailRepository promotion_detail;
    
    public DataSet() {
        staff = new StaffRepository();
        customer = new CustomerRepository();
        
        invoice = new InvoiceRepository();
        invoice_detail = new InvoicedetailRepository();
        
        product = new ProductRepository();
        product_line = new ProductLineRepository();
        producer = new ProducerRepository();
        color = new ColorRepository();
        product_detail = new ProductDetailReposytory();

        promotion = new PromotionRepository();
        promotion_detail = new PromotionDetailRepository();
    }
    
    public void staff() {
        
    }
    
    public void customer() {
        
    }
    
}
