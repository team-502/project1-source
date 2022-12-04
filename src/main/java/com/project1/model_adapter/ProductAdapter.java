/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Customer;
import com.project1.model.Product;
import com.project1.model.ProductDetail;
import com.project1.repository.implement.ProductDetailReposytory;
import com.project1.repository.implement.ProductRepository;
import com.project1.service.implement.CustomerService;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thinhorigami-rio
 */
public class ProductAdapter {

    public ProductAdapter() {

    }

    public String[] title() {
        return new String[]{
            "Mã Sản Phẩm",
            "Tên San Phẩm"
        };
    }

    public String[] toStrings(ProductDetail c) {
        return new String[]{
            c.getProduct().getIdProduct(),
            c.getProduct().getName()

        };
    }

    public DefaultTableModel model1() {
        var result = new DefaultTableModel(
                title(),
                0
        );

        for (var i : new ProductDetailReposytory().getAll()) {
            if (!i.getPromotionDetail().isPresent()) {
                result.addRow(toStrings(i));
            }
        }
        return result;
    }

    public DefaultComboBoxModel model() {
        var m = new DefaultComboBoxModel(
                new ProductRepository().getAll().stream()
                        .map((o) -> (o.getName()))
                        .toArray(String[]::new)
        );
        m.addElement("...");
        return m;
    }
}
