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
    
    public ArrayList<Product> hetByName(String name) {
        return list(query().select(root())
                .where(
                        e()
                                .equal(
                                        root().get("name"),
                                         name
                                )
                )
        );
    }
}
