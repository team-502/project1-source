/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.service.implement;

import com.project1.model.Product;
import com.project1.repository.implement.ProductRepository;
import com.project1.service.IService;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class ProductService implements IService<Product>{

    private ProductRepository repo;
    
    public ProductService() {
        repo = new ProductRepository();
    }

    @Override
    public Optional<Product> insert(Product value) {
        return repo.insert(value);
    }

    @Override
    public Optional<Product> update(Product value) {
        return repo.update(value);
    }

    @Override
    public Optional<Product> delete(Product value) {
        return repo.delete(value);
    }

    @Override
    public ArrayList<Product> getAll() {
        return repo.getAll();
    }
    
//    public ArrayList<Product> getByName(String name) {
//        return repo.getByName(name);
//    }
}
