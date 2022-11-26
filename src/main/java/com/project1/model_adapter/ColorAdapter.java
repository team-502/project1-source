/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Color;
import com.project1.model.Producer;
import com.project1.repository.implement.ColorRepository;
import com.project1.service.implement.ColorService;
import com.project1.service.implement.ProducerService;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinhorigami-rio
 */
public class ColorAdapter {
    
    public ColorAdapter() {
        
    }
    
    public DefaultComboBoxModel model() {
        var m = new DefaultComboBoxModel(
                new ColorRepository().getAll().stream()
                .map((o ) -> (o.getName()))
                .toArray(String[]::new)
        );
        m.addElement("...");
        return m;
    }
    
    public DefaultComboBoxModel searchModel() {
        var m = new DefaultComboBoxModel(
                new ColorRepository().getAll().stream()
                .map((o ) -> (o.getName()))
                .toArray(String[]::new)
        );
        m.addElement("");
        return m;
    }
    
        public String[] toStrings(Color p) {
        return new String[] {
            p.getIdColor()
            , p.getName()
        };
    }
    
    public String[] title() {
        return new String[] {
            "ma mau"
            , "ten mau"
        };
    }
    
    public DefaultTableModel tableModel() {
        var m = new DefaultTableModel(
                title()
                , 0
        );
        
        for (var i: new ColorService().getAll()) {
            m.addRow(toStrings(i));
        }
        return m;
    }
}
