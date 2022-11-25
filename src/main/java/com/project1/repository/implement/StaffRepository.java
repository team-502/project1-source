/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.Staff;
import java.util.ArrayList;

/**
 *
 * @author thinhorigami-rio
 */
public class StaffRepository extends Repository<Staff>{
    
    public StaffRepository() {
        super(Staff.class);
    }
    
    public ArrayList<Staff> getByIdAndPassword(String id_staff, String password) {
        
        var is = e().equal(root().get("idStaff"), id_staff);
        var pass = e().equal(root().get("password"), password);
        var and = e().and(is, pass);
        
        return list(query()
                .select(root())
                .where(and));
    }
}



