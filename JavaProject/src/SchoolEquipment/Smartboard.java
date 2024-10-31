/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolEquipment;

import java.util.HashMap;

/**
 *
 * @author ALJANN
 */
public class Smartboard extends Equipment{
    private static HashMap<String,Equipment> smartboards = new HashMap<>();
    private static HashMap<String,Equipment> failedSmartboards = new HashMap<>();
    
    public Smartboard(String id, String name, String type, String condition,
            String location, String quantity) {
        super(id, name, type, condition, location, quantity);
    }

    public Smartboard(String[] str) {
        super(str);
    }
    
    public Smartboard(Smartboard smart)
    {
        super(smart);
    }

    @Override
    public Equipment duplication() {
        return new Smartboard(this);
    }
    

}
