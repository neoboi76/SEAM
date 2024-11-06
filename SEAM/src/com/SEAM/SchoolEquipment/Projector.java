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
public class Projector extends Equipment {
    private static HashMap<String, Equipment> projectors = new HashMap<>();
    private static HashMap<String, Equipment> failedProjectors = new HashMap<>();
    
    public Projector(String id, String name, String type, String condition,
            String location, String quantity) {
        super(id, name, type, condition, location, quantity);
    }

    public Projector(String[] str) {
        super(str);
    }
    
    public Projector(Projector proj)
    {
        super(proj);
    }

    @Override
    public Equipment duplication() {
        return new Projector(this);
    }
    
    
}
