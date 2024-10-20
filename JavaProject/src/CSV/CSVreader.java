/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CSV;

import SchoolEquipment.Equipment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ALJANN
 */
public class CSVreader {
    public volatile ArrayList<String[]> tableRow = new ArrayList<String[]>();
    public String[] col;
    public volatile String[][] rows;
    
    public String line = "";
    public BufferedReader br = null;
    
    private int colCounter;
    private int rowCounter;
    private int smartyPants;
    
    public CSVreader(String f)
    {
        try {
            br = new BufferedReader(new FileReader(f));
            
            col = br.readLine().split(",");
            while ((line = br.readLine()) != null)
            {
                tableRow.add(line.split(","));
            }
            
            rows = tableRow.toArray(String[][]::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    public Equipment[] generateEquipment(String[][] s)
//    {
//        
//    }
}
