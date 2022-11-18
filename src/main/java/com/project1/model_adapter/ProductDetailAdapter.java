/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.repository.implement.ProductDetailReposytory;
import javax.swing.table.DefaultTableModel;
import com.project1.model.*;
import com.project1.repository.implement.ColorRepository;
/**
 *
 * @author thinhorigami-rio
 */
public class ProductDetailAdapter {

    public ProductDetailAdapter() {
    }
    
    public String[] tableTitle() {
        return new String[] {
            "ma san pham",
            "ten san pham",
            "mau sac",
            "dong san pham",
            "nha san xuat",
            "kich co",
            "so luong",
            "mo ta",
            "gia nhap",
            "gia ban"
        };
    }
    
    public String[] toStrings(ProductDetail pd) {
        return new String[] {
            pd.getProduct().getIdProduct(),
            pd.getProduct().getName(),
            pd.getColor().getName(),
            pd.getProductLine().getName(),
            pd.getProducer().getName(),
            pd.getSize() + "",
            pd.getQuantity() + "",
            pd.getDecription(),
            pd.getImportPrice() + "",
            pd.getExportPrice() + ""
        };
    }
    
    public DefaultTableModel model() {
        var list = new ProductDetailReposytory().getAll();
        
        var result = new DefaultTableModel(
                tableTitle(),
                0
        );
        
        for (var i: list) {
            result.addRow(toStrings(i));
        }
        return result;
    }
}
