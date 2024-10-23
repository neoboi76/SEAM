/*
*   The CSVreader does not merely parse the text from a .cvs file. It also acts
*   as the generator for the subclasses of Equipment depending on the equipment type
*   and location.
*
*/
package CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


/**
 *
 * @author ALJANN
 */
public class CSVreader {
    private ArrayList<String[]> tableRow = new ArrayList<>();
    
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
            tableRow = verifyRecords(tableRow);
            trueRows = tableRow.toArray(String[][]::new);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<String[]> verifyRecords(ArrayList<String[]> sample)
    {
        ArrayList<String[]> novel = new ArrayList<>();
        for (String[] s : sample)
        {
            if (s[2].equals("CPU") || s[2].equals("Computer") || 
                    s[2].equals("Keyboard") || s[2].equals("Projector") || s[2].equals("Speakers"))
                novel.add(s);
        }
        
        return novel;
    }
}
