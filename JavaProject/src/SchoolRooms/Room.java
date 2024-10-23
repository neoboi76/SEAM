/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolRooms;

import SchoolEquipment.Equipment;
import java.util.HashMap;

/**
 *
 * @author ALJANN
 */
public class Room {
    private String name;
    private String number;
    private String floorId;
    private int floorNumber;
    private HashMap<String,Equipment> hashEq = new HashMap<>();
    private int equipmentCount = hashEq.size();

    public Room(String name, String number, String floorId, int floorNumber) {
        this.name = name;
        this.number = number;
        this.floorId = floorId;
        this.floorNumber = floorNumber;
    }
}
