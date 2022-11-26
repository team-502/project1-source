/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.service.implement;

import com.project1.model.Producer;
import com.project1.repository.implement.ProducerRepository;
import com.project1.service.IService;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class ProducerService implements IService<Producer>{

    private ProducerRepository repo;
    
    public ProducerService() {
        repo = new ProducerRepository();
    }

    @Override
    public Optional<Producer> insert(Producer value) {
        return repo.insert(value);
    }

    @Override
    public Optional<Producer> update(Producer value) {
        return repo.update(value);
    }

    @Override
    public Optional<Producer> delete(Producer value) {
        return repo.delete(value);
    }

    @Override
    public ArrayList<Producer> getAll() {
        return repo.getAll();
    }
    
    public ArrayList<Producer> getByName(String name) {
        return repo.getByName(name);
    }
    
    public Optional<Producer> getByIdAndName(String id, String name) {
        return repo.getByIdAndName(id, name);
    }
}
