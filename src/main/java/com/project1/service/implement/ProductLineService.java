/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.service.implement;

import com.project1.model.ProductLine;
import com.project1.repository.implement.ProductLineRepository;
import com.project1.service.IService;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class ProductLineService implements IService<ProductLine>{

    private ProductLineRepository repo;
    
    public ProductLineService() {
        repo = new ProductLineRepository();
    }

    @Override
    public Optional<ProductLine> insert(ProductLine value) {
        return repo.insert(value);
    }

    @Override
    public Optional<ProductLine> update(ProductLine value) {
        return repo.update(value);
    }

    @Override
    public Optional<ProductLine> delete(ProductLine value) {
        return repo.delete(value);
    }

    @Override
    public ArrayList<ProductLine> getAll() {
        return repo.getAll();
    }
    
    public ArrayList<ProductLine> getByName(String name) {
        return repo.getByName(name);
    }
}
