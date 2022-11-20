/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.service.implement.ColorService;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author thinhorigami-rio
 */
public class ColorAdapter {
    
    public ColorAdapter() {
        
    }
    
    public DefaultComboBoxModel model() {
        var m = new DefaultComboBoxModel(
                new ColorService().getAll().stream()
                .map((o ) -> (o.getName()))
                .toArray(String[]::new)
        );
        return m;
    }
}
