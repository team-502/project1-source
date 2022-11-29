/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.project1;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.project1.view.Main_FR;
import com.project1.view.dialog.DateChoicedialog;
import com.project1.view.dialog.RegisterDialog;
import com.project1.view.dialog.r;
import javax.swing.UIManager;
/**
 *
 * @author thinhorigami-rio
 */
public class Project1 {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new RegisterDialog(null, true).setVisible(true);
        new Main_FR();
        System.out.println("\n ccccc\n");
    }
}















