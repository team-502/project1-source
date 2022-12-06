/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.InvoiceDetail;
import javax.swing.table.DefaultTableModel;
import com.project1.model.Invoice;
import java.math.BigInteger;

/**
 *
 * @author thinhorigami-rio
 */
public class InvoiceDetailAdapter {
    
    public String[] title() {
        return new String[] {
            "ten san pham",
            "so luong",
            "thanh vien"
        };
    }
    
    public String[] toStrings(InvoiceDetail id) {
        return new String[] {
            id.getProductDetail1().getProduct().getName(),
            id.getQuantity() + "",
            id.getProductDetail1().getExportPrice().multiply(BigInteger.valueOf(id.getQuantity())) + ""
        };
    }
    
    public DefaultTableModel model(Invoice i) {
        var m = new DefaultTableModel(
                title(),
                0
        );
        
        for (var idx: i.getInvoiceDetail()) {
            m.addRow(toStrings(idx));
        }
        
        return m;
    }
}
