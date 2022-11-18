/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.utility.view;

import javax.swing.JPanel;

/**
 *
 * @author thinhorigami-rio
 */
public class Renderer<T extends JPanel> {

    private T value;

    public Renderer(T value) {
        this.value = value;
    }

    public Renderer<T> reSize(JPanel parent) {
        this.value.resize(parent.getWidth(), parent.getHeight());
        return this;
    }
    
    public Renderer<T> setPos(int x, int y) {
        this.value.setBounds(x, y, value.getWidth(), value.getHeight());
        return this;
    }
    
    public T getDefault(JPanel parent) {
        return setPos(0, 0)
                .reSize(parent)
                .get();
    }

    public T get() {
        return value;
    }
}
