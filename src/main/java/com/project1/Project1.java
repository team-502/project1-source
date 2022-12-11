/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.project1;

import com.formdev.flatlaf.FlatDarkLaf;
import com.project1.repository.implement.ProductDetailReposytory;
import com.project1.view.Main_FR;
import javax.swing.UIManager;
/**
 *
 * @author thinhorigami-rio
 */
public class Project1 {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main_FR m = new Main_FR();
    }
}















