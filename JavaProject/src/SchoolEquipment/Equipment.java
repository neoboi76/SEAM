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
    protected String id;
    protected String name;
    protected String type;
    protected String condition;
    protected String location;
    protected String quantity;

    public Equipment(String id, String name, String type, String condition,
            String location, String quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.condition = condition;
        this.location = location;
        this.quantity = quantity;
    }
}
