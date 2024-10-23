/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;

import SchoolEquipment.Equipment;
import java.io.FileWriter;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author ALJANN
 */
public class CSVwriter {
    FileWriter fw;
    
    public CSVwriter(HashMap<String,Equipment> hm)
    {
        try {
            fw = new FileWriter("src/example.csv");
            fw.write(Equipment.writeToCSV(hm));
            fw.close();
            JOptionPane.showMessageDialog(null, "Successfully written to file", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
