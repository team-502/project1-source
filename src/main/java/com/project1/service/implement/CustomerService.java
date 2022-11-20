/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.service.implement;

import com.project1.model.Customer;
import com.project1.repository.implement.CustomerRepository;
import com.project1.service.IService;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class CustomerService implements IService<Customer>{
    
    private CustomerRepository repo;
    
    public CustomerService() {
        repo = new CustomerRepository();
    }

    @Override
    public Optional<Customer> insert(Customer value) {
        return repo.insert(value);
    }

    @Override
    public Optional<Customer> update(Customer value) {
        return repo.update(value);
    }

    @Override
    public Optional<Customer> delete(Customer value) {
        return repo.delete(value);
    }

    @Override
    public ArrayList<Customer> getAll() {
        return repo.getAll();
    }
    
}
