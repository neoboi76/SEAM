/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import SchoolEquipment.Equipment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author ALJANN
 */
public class ReportDefectivesGui extends JDialog {
    JButton okayButton;
    JLabel reportFailures;
    JPanel display;
    JTextArea textArea;
    JTextPane textPane;
    JScrollPane scrollPane;
    String collectDefects = "";
    int defectCount = 0;
    
    private String[] equipment = {"Printer", "Projector", "Speakers", "Smartboard", "Tablet"};
    private String[] location = {"MKT500", "MKT310", "MKT602"};
    private String[] condition = {"Needs Replacement", "Missing", "Disposed"};
    
    
    
    public ReportDefectivesGui(HashMap<String,Equipment> h)
    {
        super((java.awt.Frame) null, true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(600,500);
        setResizable(false);
        setTitle("EQUIPMENT TO BE REPLACED");
        
        try {
            for (Map.Entry<String,Equipment> m : h.entrySet())
            {
                if (Arrays.stream(condition).anyMatch(m.getValue().getCondition()::equals))
                {
                    collectDefects+=m.getValue().toString();
                    defectCount++;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet att = new SimpleAttributeSet();
        StyleConstants.setAlignment(att, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), att, false);
        textPane.setText(collectDefects + "\n\n" + defectCount + " equipments need to be replaced.");        
        textPane.setEditable(false);
        scrollPane = new JScrollPane(textPane);
        
        add(scrollPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
