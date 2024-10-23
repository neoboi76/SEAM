/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolEquipment;

/**
 *
 * @author ALJANN
 */
public class Projector extends Equipment {

    public Projector(String id, String name, String type, String condition,
            String location, String quantity) {
        super(id, name, type, condition, location, quantity);
    }

    public Projector(String[] str) {
        super(str);
    }
    
    
}
