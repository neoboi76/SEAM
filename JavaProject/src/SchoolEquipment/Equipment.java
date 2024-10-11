/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolEquipment;

import java.util.ArrayList;

/**
 *
 * @author ALJANN
 */
public class Equipment {
    //protected ArrayList<String> details = new ArrayList<>();
    protected String name;
    protected String condition;
    protected String id;
    protected String location;
    private int equipmentNumber;
    
    Equipment(String name, String condition, String id, String location)
    {
        this.name = name;
        this.condition = condition;
        this.id = id;
        this.location = location;
    }
    
    public void addEquipment()
    {
        equipmentNumber++;
    }
    
}
