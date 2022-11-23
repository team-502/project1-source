/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.project1;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.project1.view.Main_FR;
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
        
        var main_form = new Main_FR();
        main_form.setVisible(true);
    }
}















