/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.Producer;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class ProducerRepository extends Repository<Producer>{

    public ProducerRepository() {
        super(Producer.class);
    }
    
    public ArrayList<Producer> getByName(String name) {
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
    
    public Optional<Producer> getByIdAndName(String id, String name) {
        
        var ex_id = e().equal(root().get("idProducer"), id);
        var ex_name = e().equal(root().get("name"), name);
        
        return single(query()
                .select(root())
                .where(e().and(ex_id, ex_name))
        );
    }
}
