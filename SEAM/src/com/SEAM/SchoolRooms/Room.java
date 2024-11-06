/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SEAM.SchoolRooms;

import com.SEAM.SEAMImplements.IRoom;
import com.SEAM.SchoolEquipment.Equipment;

/**
 *
 * @author ALJANN
 */
public abstract class Room implements IRoom {
    private String name; //"MKT500", "MKT310", "MKT602"
    private String number;
    private String floorId;
    private int capacity;

    public Room(String name, String number, String floorId, int capacity) {
        this.name = name;
        this.number = number;
        this.floorId = floorId;
        this.capacity = capacity;
    }
    
    public abstract void populateTheRoom(Equipment equip);
    
    public abstract void depopulateTheRoom(Equipment equip);
    
    public abstract void clearTheRoom();

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getFloorId() {
        return floorId;
    }

    public int getCapacity() {
        return capacity;
    }
    
    
}
