/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.repository.implement;

import com.project1.model.Customer;
import com.project1.model.ProductDetail;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

/**
 *
 * @author nguyenvanviet
 */
public class CustomerFindRepo extends Repository<Customer>{
    private ArrayList<Predicate> cond; // conditions
    
    public CustomerFindRepo() {
        super(Customer.class);
        cond = new ArrayList<>();
    }
    
    public void setGender(Boolean gender) {
        
        var gt = e().equal(root().get("gender"), gender);
        
        cond.add(gt);
    }
    
    public void setState(Boolean state) {
        
        var tt = e().equal(root().get("state"), state);
        
        cond.add(tt);
    }
    
    public void setIDCustomer(String idCustomer) {
        
        var id = e().equal(root().get("idCustomer"), idCustomer);
        
        cond.add(id);
    }
    
    public void setFullName(String name) {
        
        var fullname = e().like(root().get("fullName"), name);
        
        cond.add(fullname);
    }
    public void setEmail(String email) {
        
        var mail = e().equal(root().get("email"), "%" + email + "%");
        
        cond.add(mail);
    }
    
    public void setAddress(String Address) {
        
        var address = e().like(root().get("address"), "%" + Address + "%");
        
        cond.add(address);
    }
    public void setphoneNumber(String Phone) {
        
        var phone = e().equal(root().get("phoneNumber"),"%" + Phone + "%");
        
        cond.add(phone);
    }
  
    
    public ArrayList<Customer> getResult() {
        System.out.println("\nsearch query\n");
        return list(query()
                .select(root())
               .where(e().and(this.cond.toArray(new Predicate[] {}))));
    }
    
    public ArrayList<Customer> getAllResult(String find){
        setIDCustomer(find);
        setEmail(find);
        setphoneNumber(find);
        setAddress(find);
        setFullName(find);
         return list(query()
                .select(root())
               .where(e().or(this.cond.toArray(new Predicate[] {}))));
    }
    
}


