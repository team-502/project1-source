/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.repository.IRepository;
import com.project1.utility.DBConnector;
import java.util.ArrayList;
import java.util.Optional;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author thinhorigami-rio
 */


public class Repository<T> implements IRepository<T>{
    private DBConnector connector;
    private Session session;
    private CriteriaBuilder criteria_builder;
    private Root<T> root;
    private CriteriaQuery<T> query;
    
    public Repository(Class<T> target) {
        connector = new DBConnector();
        session = connector.getSession();
        criteria_builder = session.getCriteriaBuilder();
        query =  session.getCriteriaBuilder().createQuery(target);
        root = query.from(target);
    }

    // expression
    @Override
    public CriteriaBuilder e() {
        return criteria_builder;
    }

    @Override
    public Optional<T> single(CriteriaQuery<T> query) {
        try {
            return Optional.of(session.createQuery(query).getSingleResult());
        } catch (Exception e) {
            // e.printStackTrace();
            return Optional.empty();
        }
    }
    
    @Override
    public ArrayList<T> list(CriteriaQuery<T> query) {
        return new ArrayList<T>(
                session
                        .createQuery(query)
                        .getResultList()
        );
    }
    
    @Override
    public Session session() {
        return session;
    }
    
    @Override
    public Root<T> root() {
        return root;
    }

    @Override
    public CriteriaQuery<T> query() {
        return query;
    }
    
    @Override
    public ArrayList<T> getAll() {
        return list(query.select(root));
    }

    @Override
    public Optional<T> insert(T value) {
        var t = session.beginTransaction();
        try {
            session.persist(value);
            t.commit();
            return Optional.of(value);
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
            return Optional.empty();
        }
    }

    @Override
    public Optional<T> update(T value) {
        var t = session.beginTransaction();
        try {
            session.merge(value);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
            return Optional.empty();
        }
        return Optional.of(value);
    }

    @Override
    public Optional<T> delete(T value) {
        var t = session.beginTransaction();
        try {
            session.remove(value);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
            t.rollback();
            return Optional.empty();
        }
        return Optional.of(value);
    }
    
}














