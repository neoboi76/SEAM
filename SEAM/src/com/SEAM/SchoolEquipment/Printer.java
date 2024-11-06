/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SEAM.SchoolEquipment;

import java.util.HashMap;

/**
 *
 * @author ALJANN
 */
public class Printer extends Equipment {
    
    public static HashMap<String,Equipment> printers = new HashMap<>();
    public static HashMap<String,Equipment> failedPrinters = new HashMap<>();
    
    public Printer(String id, String name, String type, String condition,
            String location, String quantity) {
        super(id, name, type, condition, location, quantity);
    }
    
    public Printer(String[] str) {
        super(str);
    }
    public Printer(Printer print)
    {
        super(print);
    }
    
    
    @Override
    public Equipment duplication() {
        return new Printer(this);
    }
    
}
