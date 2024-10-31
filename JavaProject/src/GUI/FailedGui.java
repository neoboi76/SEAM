/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import CSV.CSVreader;
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
public class FailedGui extends JDialog {
    JButton okayButton;
    JLabel reportFailures;
    JPanel display;
    JTextArea textArea;
    JTextPane textPane;
    JScrollPane scrollPane;
    String collectFailures = "";
    String collectDuplicates = "";
    
    
    
    public FailedGui(CSVreader reader)
    {
        super((java.awt.Frame) null, true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(600,500);
        setResizable(false);
        setTitle("ENTRIES NOT ADDED BECAUSE OF INVALID INPUTS");
        

        
        try {
            
            for (String[] s : reader.getErrorRow()) {
                collectFailures += reader.displayRow(s);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet att = new SimpleAttributeSet();
        StyleConstants.setAlignment(att, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), att, false);
        textPane.setText
        (collectFailures + "\n\n" + reader.getErrorRow().size() + 
                " entries not added because of errors, invalid inputs, or duplicate ID.");  //"ID\tName\tType\tCondition\tLocaton\tQuantity\n\n"+    
        textPane.setEditable(false);
        scrollPane = new JScrollPane(textPane);
        
        add(scrollPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
