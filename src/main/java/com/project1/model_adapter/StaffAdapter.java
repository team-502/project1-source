/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Staff;
import com.project1.repository.implement.StaffRepository;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinhorigami-rio
 */
public class StaffAdapter {
    
    public String[] title() {
        return new String[] {
            "ma nhan vien",
            "ten nhan vien",
            "gioi tinh",
            "tuoi",
            "email",
            "so dien thoai"
        };
    }
    
    public String[] toStrings(Staff s) {
        return new String[] {
            s.getIdStaff(),
            s.getFullName(),
            s.getGender() ? "nam" : "nu",
            s.getBirth() + "",
            s.getEmai(),
            s.getPhoneNumber()
        };
    }
    
    public DefaultTableModel model() {
        var result = new DefaultTableModel(
                title()
                , 0
        );
        
        for (var i: new StaffRepository().getAll()) {
            result.addRow(toStrings(i));
        }
        return result;
    }
}
