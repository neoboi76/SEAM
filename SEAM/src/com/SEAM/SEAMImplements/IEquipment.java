/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.SEAM.SEAMImplements;

import com.SEAM.SchoolEquipment.Equipment;
import java.util.HashMap;

/**
 *
 * @author ALJANN
 */
public interface IEquipment {
    public void displayEquipments(HashMap<String,Equipment> hm);
    
    public HashMap<String,Equipment> equipmentPopulation(HashMap<String,Equipment> hm);
    
    
}
