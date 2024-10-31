/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolEquipment;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ALJANN
 */
public abstract class Equipment {
    protected String id;
    protected String name;
    protected String type;
    protected String condition;
    protected String location;
    protected String quantity;
    protected static int itemCount = 6;

    public Equipment(String id, String name, String type, String condition,
            String location, String quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.condition = condition;
        this.location = location;
        this.quantity = quantity;
    }
    
    public Equipment(String[] str)
    {
        this.id = str[0];
        this.name = str[1];
        this.type = str[2];
        this.condition = str[3];
        this.location = str[4];
        this.quantity = str[5];
    }
    
    public Equipment(Equipment equip)
    {
        if (equip!=null)
        {
            this.id = equip.id;
            this.name = equip.name;
            this.type = equip.type;
            this.condition = equip.condition;
            this.location = equip.location;
            this.quantity = equip.quantity;   
        }
    }
    
   
    public abstract Equipment duplication();
    
    public void displayReport()
    {
        System.out.println("ID: " + this.id + " Name: " + this.name + " Type: " + this.type
        + " Condition: " + this.condition + " Location: " + this.location + " Quantity: " + this.quantity);
    }

    @Override
    public String toString() {
        return id + "," + name + "," + type + "," + condition + "," + location + "," + quantity + '\n';
    }
    
    /**
     * Standard function that describes the details of a specific equipment
     * 
     * 
     * @return String = a description of the specific equipment's details
     */
    public String equipmentDetails()
    {
        return 
                "Id: " + id + '\n' +
                "Name of Equipment: " + name + '\n' +
                "Equipment Type: " + type + '\n' +
                "Condition: " + condition + '\n' +
                "Located in Room: " + location + '\n' +
                "Date Stored: " + '\n';
    }
    
    public String[] returnArrayOfStrings()
    {
        String [] s = new String[itemCount];
        s[0] = id;
        s[1] = name;
        s[2] = type;
        s[3] = condition;
        s[4] = location;
        s[5] = quantity;
        
        return s;
    }
    
    /**
     * Accrues the return String with ready-made CSV String for easy transfer
     * into the CSVwriter class.
     * 
     * @param hash
     * @return the accrued CSV string ready for translation into .csv file
     */
    public static String writeToCSV(HashMap<String,Equipment> hash)
    {
        String collate = "";
        for (Map.Entry<String,Equipment> m : hash.entrySet())
        {
            collate+=m.getValue().toString();
        }
        
        return collate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCondition() {
        return condition;
    }

    public String getLocation() {
        return location;
    }

    public String getQuantity() {
        return quantity;
    }
    
    
    
    
}
