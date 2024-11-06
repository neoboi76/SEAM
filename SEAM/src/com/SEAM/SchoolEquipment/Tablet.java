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
public class Tablet extends Equipment {
    private static HashMap<String, Equipment> tablets = new HashMap<>();
    private static HashMap<String, Equipment> failedTablets = new HashMap<>();
    
    public Tablet(String id, String name, String type, String condition,
            String location, String quantity) {
        super(id, name, type, condition, location, quantity);
    }
    public Tablet(String[] str) {
        super(str);
    }
    
    public Tablet(Tablet tab)
    {
        super(tab);            
    }

    @Override
    public Equipment duplication() {
        return new Tablet(this);
    }
}
