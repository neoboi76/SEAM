/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;

import SchoolEquipment.Equipment;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
/**
 *
 * @author ALJANN
 */
public class CSVwriter {
    FileWriter fw;
    File folder = new File("./src");
//    FileFilter fileFilter = new WildcardFileFilter("*.csv", IOCase.INSENSITIVE);
    File[] files = folder.listFiles();
    String columns = "ID,Name,Type,Condition,Location,Quantity\n";
    
    public CSVwriter()
    {
        try {
            if (files.length > 0)
            {
                Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean fileExists(String string)
    {   
        ArrayList<String> fNames = new ArrayList<>();
        Arrays.stream(files).forEach((f) -> fNames.add(f.getName()));
        return fNames.stream().anyMatch((string+".csv")::equals);
    }
    
    public void writeFile(String fileLocation, HashMap<String,Equipment> hm)
    {
        try {
            fw = new FileWriter("src/" + fileLocation + ".csv");
            fw.write(columns);
            fw.write(Equipment.writeToCSV(hm));
            fw.close();
            JOptionPane.showMessageDialog(null, "Successfully written to file", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveFile(String fileLocation, HashMap<String,Equipment> hm)
    {
        try {
            fw = new FileWriter(fileLocation);
            fw.write(columns);
            fw.write(Equipment.writeToCSV(hm));
            fw.close();
            JOptionPane.showMessageDialog(null, "Successfully written to file", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
