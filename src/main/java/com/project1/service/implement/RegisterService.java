/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.service.implement;

import com.project1.model.Staff;
import com.project1.repository.implement.StaffRepository;
import com.project1.service.IService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tkien
 */
public class RegisterService implements IService<Staff>{
    private StaffRepository staffrepo;
    public RegisterService(){
        staffrepo = new StaffRepository();
    }

    @Override
    public Optional<Staff> insert(Staff value) {
        return staffrepo.insert(value);    
    }

    @Override
    public Optional<Staff> update(Staff value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Staff> delete(Staff value) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Staff> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
