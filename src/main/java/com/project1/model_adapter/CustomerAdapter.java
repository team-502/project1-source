/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Customer;
import com.project1.service.implement.CustomerService;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinhorigami-rio
 */
public class CustomerAdapter {
    
    public String[] title() {
        return new String[] {
            "ma khach hang",
            "ten khach hang",
            "gioi tinh",
            "email",
            "dia chi",
            "so dien thoai",
            "trang thai"
        };
    }
    
    public String[] toStrings(Customer c) {
        return new String[] {
            c.getIdCustomer(),
            c.getFullName(),
            c.getGender() ? "nam" : "nu",
            c.getEmail(),
            c.getAddress(),
            c.getPhoneNumber(),
            c.getState() ? "con hoat dong" : "khong hoat dong"
        };
    }
    
    public DefaultTableModel model() {
        var result = new DefaultTableModel(
                title(),
                0
        );
        
        for (var i: new CustomerService().getAll()) {
            result.addRow(toStrings(i));
        }
        return result;
    }
    
}
