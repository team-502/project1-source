/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.project1;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.project1.repository.implement.ProductLineRepository;
import com.project1.view.Login_fr;
import com.project1.view.Main_FR;
import com.project1.view.Register;
import javax.swing.UIManager;
/**
 *
 * @author thinhorigami-rio
 */
public class Project1 {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        var login = new Login_fr();
        login.setVisible(true);
        
        System.out.println("\n ccccc\n");
    }
}















