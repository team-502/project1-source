/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Producer;
import com.project1.repository.implement.ProducerRepository;
import com.project1.service.implement.ProducerService;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinhorigami-rio
 */
public class ProducerAdapter {
    
    public DefaultComboBoxModel model() {
        var m = new DefaultComboBoxModel(
                new ProducerRepository()
                        .getAll()
                        .stream()
                        .map((o ) -> (o.getName()))
                        .toArray(String[]::new)
        );
        m.addElement("...");
        return m;
    }
    
    public DefaultComboBoxModel searchModel() {
        var m = new DefaultComboBoxModel(
                new ProducerRepository()
                        .getAll()
                        .stream()
                        .map((o ) -> (o.getName()))
                        .toArray(String[]::new)
        );
        m.addElement("");
        return m;
    }
    
    
    public String[] toStrings(Producer p) {
        return new String[] {
            p.getIdProducer()
            , p.getName()
        };
    }
    
    public String[] title() {
        return new String[] {
            "ma nha san xuat"
            , "ten nha san xuat"
        };
    }
    
    public DefaultTableModel tableModel() {
        var m = new DefaultTableModel(
                title()
                , 0
        );
        
        for (var i: new ProducerService().getAll()) {
            m.addRow(toStrings(i));
        }
        return m;
    }
}
