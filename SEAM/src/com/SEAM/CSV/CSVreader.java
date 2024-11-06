/**
*   The CSVreader does not merely parse the text from a .cvs file. It also acts
*   as the generator for the subclasses of Equipment depending on the equipment type
*   and location.
*   
*
*/
package com.SEAM.CSV;

import com.SEAM.SEAMImplements.ReferenceObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


/**
 *
 * @author ALJANN
 */
public class CSVreader {
    private ArrayList<String[]> tableRow = new ArrayList<>();
    private ArrayList<String[]> errorRow = new ArrayList<>();
    
    private String[] equipment = ReferenceObject.getEqList();
    private String[] location = ReferenceObject.getRoomList();
    private String[] condition = ReferenceObject.getCondiList();
    
    private String[] col;
    private String[][] rows;
    private String[][] trueRows;
    
    private String line = "";
    private BufferedReader br = null;
    
    private int colCounter;
    private int rowCounter;

    public String[] getCol() {
        return col;
    }

    public String[][] getRows() {
        return rows;
    }
    
    public ArrayList<String[]> getTableRow() {
        return tableRow;
    }

    public String[][] getTrueRows() {
        return trueRows;
    }

    public ArrayList<String[]> getErrorRow() {
        return errorRow;
    }

    
    
    /**
     * The CSVreader parses a .csv file to TableModel values for JTable construction.
     * @param f
     */
    public CSVreader(String f)
    {
        readCSV(f);
    }
    
    public ArrayList<String[]> verifyRecords(ArrayList<String[]> sample)
    {
        
        ArrayList<String[]> novel = new ArrayList<>();
        ArrayList<String[]> filtered = new ArrayList<>();
        ArrayList<String[]> duplicates = new ArrayList<>();
        HashSet<Object> set = new HashSet<>();
        
        for (String[] s : sample)
        {
            if (Arrays.stream(equipment).anyMatch(s[2]::equals) &&
                    Arrays.stream(condition).anyMatch(s[3]::equals) &&
                    Arrays.stream(location).anyMatch(s[4]::equals))
                novel.add(s);
        }
        
        for (String[] s : novel) {
            String id = s[0];
            if (set.contains(id)) {
                duplicates.add(s);
            } else {
                filtered.add(s);
                set.add(id);
            }
        }
        
        return filtered;
    }
        
    
    public ArrayList<String[]> failedRecords(ArrayList<String[]> sample)
    {
        ArrayList<String[]> novel = new ArrayList<>();
        for (String[] s : sample) 
        {
            if ((!Arrays.stream(equipment).anyMatch(s[2]::equals)) || 
                    (!Arrays.stream(condition).anyMatch(s[3]::equals)) ||
                    (!Arrays.stream(location).anyMatch(s[4]::equals)))
                novel.add(s);
        }
        
        ArrayList<String[]> filtered = new ArrayList<>();
        ArrayList<String[]> duplicates = new ArrayList<>();
        HashSet<Object> set = new HashSet<>();
        
        for (String[] s : sample) {
            String id = s[0];
            if (set.contains(id) && !novel.contains(s)) {
                duplicates.add(s);
            }
            else{
                filtered.add(s);
                set.add(id);
            }
        }
        duplicates.addAll(novel);
        
        return duplicates;
    }
    
    public String displayRow(String[] s)
    {
        return s[0]+'\t'+s[1]+'\t'+s[2]+'\t'+s[3]+'\t'+s[4]+'\t'+s[5]+'\t'+'\n';
    }
    
    
    public void readCSV(String f)
    {
        try {
            br = new BufferedReader(new FileReader(f));

            col = br.readLine().split(",");
            while ((line = br.readLine()) != null) {
                tableRow.add(line.split(","));
            }
            rows = tableRow.toArray(String[][]::new);
            errorRow = failedRecords(tableRow);
            tableRow = verifyRecords(tableRow);
            trueRows = tableRow.toArray(String[][]::new);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
            
}
