/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.project1.service;

import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public interface IService<T> {
    public Optional<T> insert(T value);
    public Optional<T> update(T value);
    public Optional<T> delete(T value);
    public ArrayList<T> getAll();
}
