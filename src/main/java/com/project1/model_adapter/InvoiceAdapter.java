/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Invoice;
import com.project1.model.ProductDetail;
import com.project1.repository.implement.ProductDetailReposytory;
import com.project1.service.implement.InvoiceService;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinhorigami-rio
 */
public class InvoiceAdapter {
    
    public InvoiceAdapter() {
        
    }
    
    public String[] invoiceQueuetitle() {
        return new String[] {
            "ma hoa don",
            "ngay tao",
            "ma nhan vien",
            "ten khach hang"
        };
    }
    
    public String[] invoiceQueueToStrings(Invoice invoice) {
        return new String[] {
            invoice.getIdInvoice(),
            invoice.getCreatedDate() + "",
            invoice.getStaff().getIdStaff(),
            invoice.getCustomer().getFullName()
        };
    }
    
    public DefaultTableModel invoiceQueueModel(ArrayList<Invoice> invoices) {
        var m = new DefaultTableModel(
                invoiceQueuetitle(),
                0
        );
        
        for (var i: invoices) {
            m.addRow(invoiceQueueToStrings(i));
        }
        
        return m;
    }
    
    public String[] listProductTitle() {
        return new String[] {
            "ma san pham",
            "ten san pham",
            "mau sac",
            "dong san pham",
            "nha san xuat",
            "kich co",
            "so luong",
            "mo ta",
            "gia ban"
        };
    }
    
    public String[] listProductToStrings(ProductDetail pd) {
        return new String[] {
            pd.getProduct().getIdProduct(),
            pd.getProduct().getName(),
            pd.getColor().getName(),
            pd.getProductLine().getName(),
            pd.getProducer().getName(),
            pd.getSize() + "",
            pd.getQuantity() + "",
            pd.getDecription(),
            pd.getExportPrice() + ""
        };
    }
    
    public DefaultTableModel listProductModel(ArrayList<Invoice> cart) {
        var m = new DefaultTableModel(listProductTitle(), 0);
        
        var service = new InvoiceService();
        
        for (var i: service.geProdctsState(cart)) {
            m.addRow(listProductToStrings(i));
        }
        
        return m;
    }
}
