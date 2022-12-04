/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.service.implement;

import com.project1.model.Staff;
import com.project1.repository.implement.StaffRepository;
import com.project1.service.IService;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class StaffService implements IService<Staff> {
    private StaffRepository repo;

    public StaffService() {
        repo = new StaffRepository();
    }
    
    @Override
    public Optional<Staff> insert(Staff value) {
        if (repo.findByIdStaff(value.getIdStaff()).isPresent()) {
            return Optional.empty();
        }
        return repo.insert(value);
    }

    @Override
    public Optional<Staff> update(Staff value) {
        return repo.update(value);
    }

    @Override
    public Optional<Staff> delete(Staff value) {
        return repo.delete(value);
    }

    @Override
    public ArrayList<Staff> getAll() {
        return repo.getAll();
    }
    
    public Optional<Staff> login(String id_staff, String password) {
        return repo.getByIdAndPassword(id_staff, password);
    }
}
