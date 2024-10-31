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
public class Speakers extends Equipment {
    private static HashMap<String, Equipment> speakers = new HashMap<>();
    private static HashMap<String, Equipment> failedSpeakers = new HashMap<>();
    
    public Speakers(String id, String name, String type, String condition,
            String location, String quantity) {
        super(id, name, type, condition, location, quantity);
    }
    public Speakers(String[] str) {
        super(str);
    }
    public Speakers(Speakers speak)
    {
        super(speak);
    }

    @Override
    public Equipment duplication() {
        return new Speakers(this);
    }
}
