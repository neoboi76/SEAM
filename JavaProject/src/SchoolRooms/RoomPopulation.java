/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SchoolRooms;

import SchoolEquipment.Equipment;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author ALJANN
 */
public class RoomPopulation {
    public void populateRoomHashMap(HashMap<String,Equipment> hm, Room one, Room two, Room three)
    {
        for (Map.Entry<String, Equipment> m : hm.entrySet()) {
            switch (m.getValue().getLocation()) {
                case "MKT500" ->
                    one.populateTheRoom(m.getValue());
                case "MKT310" ->
                    two.populateTheRoom(m.getValue());
                case "MKT602" ->
                    three.populateTheRoom(m.getValue());
                default ->
                    JOptionPane.showMessageDialog(null, "Invalid Type!", "INVALID TYPE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void depopulateRoomHashMap(Equipment equip, Room one, Room two, Room three)
    {
         
        switch (equip.getId()) {
            case "MKT500" ->
                one.depopulateTheRoom(equip);
            case "MKT310" ->
                two.depopulateTheRoom(equip);
            case "MKT602" ->
                three.depopulateTheRoom(equip);
            default ->
                JOptionPane.showMessageDialog(null, "Invalid Type!", "INVALID TYPE", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void clearRoomHashMap(Room one, Room two, Room three)
    {
        one.clearTheRoom();
        two.clearTheRoom();
        three.clearTheRoom();
    }
}
