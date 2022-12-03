/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.service.implement;

import com.project1.model.Invoice;
import com.project1.model.ProductDetail;
import com.project1.repository.implement.InvoiceRepository;
import com.project1.repository.implement.ProductDetailReposytory;
import com.project1.service.IService;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

/**
 *
 * @author trx
 */
public class InvoiceService implements IService<Invoice> {

    private InvoiceRepository repo;
    
    public InvoiceService() {
        repo = new InvoiceRepository();
    }
    
    @Override
    public Optional<Invoice> insert(Invoice value) {
        return repo.insert(value);
    }

    @Override
    public Optional<Invoice> update(Invoice value) {
        return repo.update(value);
    }

    @Override
    public Optional<Invoice> delete(Invoice value) {
        return repo.delete(value);
    }

    @Override
    public ArrayList<Invoice> getAll() {
        return repo.getAll();
    }
    
    public BigInteger gettotalPrice(Invoice invoice) {
        var r = new BigInteger("0");
        
        for (var i: invoice.getInvoiceDetail()) {
            r = r.add(new BigInteger(i.getProductDetail1().getExportPrice().toString())
                .multiply(new BigInteger(i.getQuantity() + "")));
        }
        return r;
    }
    
    public ArrayList<ProductDetail> geProdctsState(ArrayList<Invoice> cart) {
        
        var cart_products = new HashMap<ProductDetail, Integer>();
        for (var i: cart) {
            for (var j: i.getInvoiceDetail()) {
                if (cart_products.containsKey(j)) {
                        cart_products.put(
                        j.getProductDetail1()
                        ,cart_products.get(j.getProductDetail1()) + j.getQuantity()
                    );                             
                } else {
                     cart_products.put(
                        j.getProductDetail1()
                        , j.getQuantity()
                    );  
                }

            }
        }
        var products = new ProductDetailReposytory().getAll();
        
        for (var i: products) {
            if (cart_products.containsKey(i)) {
                i.setQuantity(i.getQuantity() - cart_products.get(i));
            }
        }
        
        return products;
    }
    
}
