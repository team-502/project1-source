/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.Color;
import java.util.ArrayList;

/**
 *
 * @author thinhorigami-rio
 */
public class ColorRepository extends Repository<Color> {

    public ColorRepository() {
        super(Color.class);
    }
    
    public ArrayList<Color> getByName(String name) {
        
        return list(query().select(root())
            .where(
                e()
                    .equal(
                        root().get("name")
                        , name
                    )
                )
        );
    }
}
