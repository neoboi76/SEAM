/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolRooms;

import SchoolEquipment.Equipment;

/**
 *
 * @author ALJANN
 */
public class Room {
    private String name;
    private String number;
    private String id;
    private int floorNumber;
    private Equipment[] equipments = null;
    private int equipmentCount = equipments.length;

    public Room(String name, String number, String id, int floorNumber) {
        this.name = name;
        this.number = number;
        this.id = id;
        this.floorNumber = floorNumber;
    }
}
