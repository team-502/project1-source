/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;


import com.project1.model.Product;
import java.util.ArrayList;
import java.util.Optional;
/**
 *
 * @author thinhorigami-rio
 */

public class ProductRepository extends Repository<Product> {

    public ProductRepository() {
        super(Product.class);
    }
    
    public ArrayList<Product> getByIdProductAndName(String ip, String n) {
        
        var id_product = e().equal(root().get("idProduct"), ip);
        var name = e().equal(root().get("name"), n);
        var id_product_and_name = e().and(id_product, name);
        
        return list(query()
                .select(root())
                .where(id_product_and_name));
    }
    
    public ArrayList<Product> getByIdProduct(String ip) {
        
        var id_product = e().equal(root().get("idProduct"),ip);
        
        return list(query()
                .select(root())
                .where(id_product));
    }
    
    public boolean findByNameOrIdProduct(String n, String ip) {
        
        var id_product = e().equal(root().get("idProduct"), ip);
        var name = e().equal(root().get("name"), n);
        var or = e().or(id_product, name);
        return !list(query()
                .select(root())
                .where(or)).isEmpty();
    }
    
    public ArrayList<Product> getByName(String n) {
        
        var name = e().equal(root().get("name"), n);
        
        return list(query()
                .select(root())
                .where(name));
    }
}
