/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SEAM.SchoolEquipment;

import com.SEAM.CSV.CSVreader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author ALJANN
 */
public class EquipmentFactory {
    
    public ArrayList<Equipment> createArrayListEquipFromFile(CSVreader csv)
    {
        ArrayList<Equipment> equipments = new ArrayList<>();
        
        for (String[] s:csv.getTableRow())
        {
            switch(s[2])
            {
                case "Smartboard" -> equipments.add(new Smartboard(s));
                case "Projector" -> equipments.add(new Projector(s));
                case "Speakers" -> equipments.add(new Speakers(s));
                case "Printer" -> equipments.add(new Printer(s));
                case "Tablet" -> equipments.add(new Tablet(s));
                default -> JOptionPane.showMessageDialog(null, "Invalid Type!", "INVALID TYPE", JOptionPane.ERROR_MESSAGE);
            }
        }
        return equipments;
    }
    public HashMap<String,Equipment> createHashMapEquipFromFile(CSVreader csv) {
        HashMap<String,Equipment> hashEq = new HashMap<>();
        Equipment e;

        for (String[] s : csv.getTableRow()) {
            switch (s[2]) {
                case "Smartboard" ->
                    e = new Smartboard(s);
                case "Projector" ->
                    e = new Projector(s);
                case "Speakers" ->
                    e = new Speakers(s);
                case "Printer" ->
                    e = new Printer(s);
                case "Tablet" ->
                    e = new Tablet(s);
                default ->
                {
                    e = null;
                    JOptionPane.showMessageDialog(null, "Invalid Type!", "INVALID TYPE", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            if (e != null)
                hashEq.put(e.id, e);
        }
        return hashEq;
    }
    public Equipment createEquipmentFromInsert(String[] s)
    {
        Equipment e = null;
        switch (s[2]) 
        {
            case "Smartboard" -> e = new Smartboard(s);
            case "Projector" -> e = new Projector(s);
            case "Speakers" -> e = new Speakers(s);
            case "Printer" -> e = new Printer(s);
            case "Tablet" -> e =  new Tablet(s);
            default -> JOptionPane.showMessageDialog(null, "Invalid Type!", "INVALID TYPE", JOptionPane.ERROR_MESSAGE);
        }
        return e;
    }
}
