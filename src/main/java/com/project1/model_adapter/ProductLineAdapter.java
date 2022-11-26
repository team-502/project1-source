/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Producer;
import com.project1.model.ProductLine;
import com.project1.repository.implement.ProductLineRepository;
import com.project1.service.implement.ProducerService;
import com.project1.service.implement.ProductLineService;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinhorigami-rio
 */
public class ProductLineAdapter {
    
    public ProductLineAdapter() {
        
    }
    
    public DefaultComboBoxModel model() {
        var m = new DefaultComboBoxModel(
                new ProductLineRepository()
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
                new ProductLineRepository()
                        .getAll()
                        .stream()
                        .map((o) -> (o.getName()))
                        .toArray(String[]::new)
        );
        m.addElement("");
        return m;
    }
    
    public String[] toStrings(ProductLine p) {
        return new String[] {
            p.getIdProductLine()
            , p.getName()
        };
    }
    
    public String[] title() {
        return new String[] {
            "ma dong san pham"
            , "ten dong san pham"
        };
    }
    
    public DefaultTableModel tableModel() {
        var m = new DefaultTableModel(
                title()
                , 0
        );
        
        for (var i: new ProductLineService().getAll()) {
            m.addRow(toStrings(i));
        }
        return m;
    }
}
