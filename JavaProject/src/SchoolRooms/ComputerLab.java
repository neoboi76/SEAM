/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolRooms;

import SchoolEquipment.Equipment;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ALJANN
 */
public class ComputerLab extends Room {
    private HashMap<String, Equipment> hashEq = new HashMap<>();
    private int equipmentCount = hashEq.size();

    public ComputerLab(String name, String number, String floorId, int capacity) {
        super(name, number, floorId, capacity);
    }
    
    @Override
    public String listOfEquipments() {
        String collate = "";
        collate += "Room " + super.getName() + " contains the following equipments: " + '\n';
        for (Map.Entry<String, Equipment> m : hashEq.entrySet()) {
            collate += m.getValue().getId() + " " + m.getValue().getName() + " "
                    + m.getValue().getType() + " " + m.getValue().getCondition() + " "
                    + m.getValue().getLocation() + " " + m.getValue().getQuantity() + '\n';
        }
        collate += '\n';
        return collate;
    }


    @Override
    public void populateTheRoom(Equipment equip) {
        hashEq.put(equip.getId(), equip);
    }

    @Override
    public void depopulateTheRoom(Equipment equip) {
        hashEq.remove(equip.getId());
    }

    @Override
    public void clearTheRoom() {
        hashEq.clear();
    }
    
    
}
