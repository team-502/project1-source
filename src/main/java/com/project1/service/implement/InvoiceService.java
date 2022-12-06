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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
    
    public BigInteger getPromotionPrice(Invoice invoice) {
        var price = new BigInteger("0");
        
        for (var i: invoice.getInvoiceDetail()) {
            var t = i.getProductDetail1().getPromotionDetail();
            if (t.isPresent()) {
                if (t.get().getPromotion().getEndDate().compareTo(new Date()) < 0) {
                    break;
                }
                if (t.get().getPromotion().getType()) {
                    price = price.add(i.getProductDetail1().getExportPrice()
                            .multiply(BigInteger.valueOf(t.get().getPromotion().getPercent()))
                            .divide(BigInteger.valueOf(100))
                            .multiply(BigInteger.valueOf(i.getQuantity()))
                    );
                } else {
                    price = price.add(
                        t.get().getPromotion().getMoney()
                        .multiply(BigInteger
                        .valueOf(i.getQuantity()))
                    );
                }
            }
            System.out.println("\n" + price.toString() + "\n");
        }
        return price;
    }
    
    public Optional<BigInteger> getFinalPrice(Invoice invoice) {
        
        var final_price = gettotalPrice(invoice).subtract(getPromotionPrice(invoice));
        try {
            if (invoice.getPayment().compareTo(final_price) < 0) {
                return Optional.empty();
            }
            return Optional.of(invoice.getPayment().subtract(final_price));
        } catch (Exception e) {
            return Optional.empty();
        }
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
    
    public Optional<Invoice> getByIdInvoice(String id) {
        return repo.getByIdInvoice(id);
    }
    
}
