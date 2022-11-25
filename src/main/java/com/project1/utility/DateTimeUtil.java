/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project1.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

/**
 *
 * @author thinhorigami-rio
 */
public class DateTimeUtil {
    
    private int day, month, year;
    
    public DateTimeUtil(int day, int month,int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public Optional<Date> getDate() throws ParseException {
        
        if (!this.isLeapYear() && (day > 28 && month == 2) ) {
            return Optional.empty();
        }
        
        return Optional.of(new SimpleDateFormat("dd-MM-yyyy")
                .parse(LocalDate
                .of(year, month, day).toString()));
    }
    
    public boolean isLeapYear() {
        if ((year % 4 == 0 && year % 100 != 0)
            || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
