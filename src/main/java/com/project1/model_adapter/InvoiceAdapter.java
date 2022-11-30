/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Invoice;
import java.util.ArrayList;
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
    
}
