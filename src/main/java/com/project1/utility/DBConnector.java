/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.utility;

import com.project1.model.Staff;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author thinhorigami-rio
 */
public class DBConnector {
    private SessionFactory session_factory;
    
    public DBConnector() {
        this.session_factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Staff.class)
                .buildSessionFactory();
    }
    
    
}
