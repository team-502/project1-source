/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project1.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Optional;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author thinhorigami-rio
 */
public interface IRepository<T> {
    
    public Root<T> root();
    public CriteriaQuery<T> query();
    public CriteriaBuilder e();
    public ArrayList<T> getAll();
    public Optional<T> insert(T value);
    public Optional<T> update(T value);
    public Optional<T> delete(T value);
    public Session session();
    public Optional<T> single(CriteriaQuery<T> query);
    public ArrayList<T> list(CriteriaQuery<T> query);
}
