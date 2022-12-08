/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.model_adapter;

import com.project1.model.Customer;
import com.project1.model.PromotionDetail;
import com.project1.repository.implement.PromotionDetailRepository;
import com.project1.repository.implement.PromotionRepository;
import com.project1.service.implement.CustomerService;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguyenvanviet
 */
public class promotionAdater {
    public String[] title() {
        return new String[] {
            "ma khuyen mai",
            "ten khuyen mai",
            "hinh thuc giảm",
            "muc giam",
            "san pham",
            "ngay bat dau",
            "ngay ket thuc",
            "Trang Thai",
            "Mo ta"
        };
    }
    
    public String[] toStrings(PromotionDetail c) {
        return new String[] {
            c.getPromotion().getId(),
            c.getPromotion().getName(),
            c.getPromotion().getType() ? "Theo phần Trăm" : "Theo giá Tiền",
            c.getPromotion().getType() ? c.getPromotion().getPercent() + "%" : c.getPromotion().getMoney() + "",
            c.getProductDetail().getProduct().getName(),
            c.getPromotion().getStateDate().toString(),
            c.getPromotion().getEndDate().toString(),
            c.getPromotion().isState() ? "Còn Thời Hạn" : "Đã Hết Hạn"
            
        };
    }
    
    public DefaultTableModel model() {
        var result = new DefaultTableModel(
                title(),
                0
        );
        
        for (var i: new PromotionDetailRepository().getAll()) {
            result.addRow(toStrings(i));
        }
        return result;
    }
     
    
    
}
