/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Invoice;
import com.project1.model.InvoiceDetail;
import com.project1.model.ProductDetail;
import com.project1.repository.implement.ProductDetailReposytory;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenvanviet
 */
public class GioHangAdater {
    public GioHangAdater(){
        
    }
    public String[] tableTitle() {
        return new String[] {
            "ma san pham",
            "ten san pham",
            "Don gia",
            "so luong"

        };
    }
    
    public String[] toStrings(InvoiceDetail pd) {
        return new String[] {
            pd.getProductDetail1().getProduct().getIdProduct(),
            pd.getProductDetail1().getProduct().getName(),
            pd.getProductDetail1().getExportPrice() + "",
            pd.getQuantity() + "",
            
        };
    }
    public DefaultTableModel model(Invoice ivoice) {
        
        var result = new DefaultTableModel(
                tableTitle(),
                0
        );
        
        for (var i: ivoice.getInvoiceDetail()) {
            result.addRow(toStrings(i));
        }
        return result;
    }
}
