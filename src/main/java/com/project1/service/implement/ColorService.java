package com.project1.service.implement;


import com.project1.model.Color;
import com.project1.repository.implement.ColorRepository;
import com.project1.service.IService;
import java.util.ArrayList;
import java.util.Optional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author thinhorigami-rio
 */
public class ColorService implements IService<Color>{

    private ColorRepository repo;
    
    public ColorService() {
        repo = new ColorRepository();
    }

    @Override
    public Optional<Color> insert(Color value) {
        return repo.insert(value);
    }

    @Override
    public Optional<Color> update(Color value) {
        return repo.update(value);
    }

    @Override
    public Optional<Color> delete(Color value) {
        return repo.delete(value);
    }

    @Override
    public ArrayList<Color> getAll() {
        return repo.getAll();
    }
    
    public ArrayList<Color> getByName(String name) {
        return repo.getByName(name);
    }
}
