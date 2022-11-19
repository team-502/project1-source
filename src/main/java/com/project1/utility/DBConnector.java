/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.utility;

import com.project1.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author thinhorigami-rio
 */
public class DBConnector {
    private SessionFactory session_factory;
    
    public DBConnector() {
        try {
            this.session_factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Color.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Invoice.class)
                    .addAnnotatedClass(InvoiceDetail.class)
                    .addAnnotatedClass(Producer.class)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(ProductDetail.class)
                    .addAnnotatedClass(ProductLine.class)
                    .addAnnotatedClass(Promotion.class)
                    .addAnnotatedClass(PromotionDetail.class)
                    .addAnnotatedClass(Staff.class)
                    .buildSessionFactory();              
        } catch (Exception e) {
            System.out.println("connect falied");
        }
    }
    
    public Session getSession() {
        return this.session_factory.openSession();
    }
}
