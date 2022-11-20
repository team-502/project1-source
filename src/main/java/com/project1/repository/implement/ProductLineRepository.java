/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.ProductLine;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class ProductLineRepository extends Repository<ProductLine>{

    public ProductLineRepository() {
        super(ProductLine.class);
    }
    
    public ArrayList<ProductLine> getByName(String name) {
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
