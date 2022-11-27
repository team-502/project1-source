/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.Customer;
import java.util.ArrayList;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class CustomerRepository extends Repository<Customer> {

    public CustomerRepository() {
        super(Customer.class);
    }

    public ArrayList<Customer> getByName(String name) {
        return list(query().select(root())
                .where(
                        e()
                                .equal(
                                        root().get("name"),
                                        name
                                )
                )
        );
    }

    public ArrayList<Customer> getByGT(String gt) {
        return list(query().select(root())
                .where(
                        e()
                                .equal(
                                        root().get("gender"),
                                        gt
                                )
                )
        );
    }
    
    public ArrayList<Customer> getByTT(Boolean tt) {
        return list(query().select(root())
                .where(
                        e()
                                .equal(
                                        root().get("state"),
                                        tt
                                )
                )
        );
    }
}
