/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project1.repository;

import java.util.ArrayList;
import java.util.Optional;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 *
 * @author thinhorigami-rio
 */
public interface IRepository<T> {
    
    public Root<T> root();
    public CriteriaQuery<T> query();
    public ArrayList<T> getAll();
    public Optional<T> insert(T value);
    public Optional<T> update(T value);
    public Optional<T> delete(T value);
    
}
