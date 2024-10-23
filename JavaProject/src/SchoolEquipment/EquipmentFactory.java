/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolEquipment;

import CSV.CSVreader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author ALJANN
 */
public class EquipmentFactory {
    
    public ArrayList<Equipment> createEquipmentsFromFile(CSVreader csv)
    {
        ArrayList<Equipment> equipments = new ArrayList<>();
        
        for (String[] s:csv.getTableRow())
        {
            switch(s[2])
            {
                case "Computer" -> equipments.add(new Computer(s));
                case "Projector" -> equipments.add(new Projector(s));
                case "Speakers" -> equipments.add(new Speakers(s));
                case "CPU" -> equipments.add(new CPU(s));
                case "Keyboard" -> equipments.add(new Keyboard(s));
                default -> JOptionPane.showMessageDialog(null, "Invalid Type!", "INVALID TYPE", JOptionPane.ERROR_MESSAGE);
            }
        }
        return equipments;
    }
    public HashMap<String,Equipment> createHashMapEquipFromFile(CSVreader csv) {
        HashMap<String,Equipment> hashEq = new HashMap<>();
        Equipment e = null;

        for (String[] s : csv.getTableRow()) {
            switch (s[2]) {
                case "Computer" ->
                    e = new Computer(s);
                case "Projector" ->
                    e = new Projector(s);
                case "Speakers" ->
                    e = new Speakers(s);
                case "CPU" ->
                    e = new CPU(s);
                case "Keyboard" ->
                    e = new Keyboard(s);
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
            case "Computer" -> e = new Computer(s);
            case "Projector" -> e = new Projector(s);
            case "Speakers" -> e = new Speakers(s);
            case "CPU" -> e = new CPU(s);
            case "Keyboard" -> e =  new Keyboard(s);
            default -> JOptionPane.showMessageDialog(null, "Invalid Type!", "INVALID TYPE", JOptionPane.ERROR_MESSAGE);
        }
        return e;
    }
}
