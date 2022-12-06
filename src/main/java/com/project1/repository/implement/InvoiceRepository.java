/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.Invoice;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class InvoiceRepository extends Repository<Invoice> {
    
    public InvoiceRepository() {
        super(Invoice.class);
    }
    
    public Optional<Invoice> getByIdInvoice(String id) {
        var find = e().equal(root().get("idInvoice"), id);
        return single(query()
            .select(root())
            .where(find));
    }
}
