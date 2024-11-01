/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import CSV.CSVreader;
import SchoolEquipment.Equipment;
import SchoolRooms.Room;
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
public class DisplayRoomGui extends JDialog {
    JButton okayButton;
    JLabel reportFailures;
    JPanel display;
    JTextArea textArea;
    JTextPane textPane;
    JScrollPane scrollPane;
    String collectRooms = "";
    String collectDuplicates = "";
    
    
    
    public DisplayRoomGui(Room room)
    {
        super((java.awt.Frame) null, true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(600,500);
        setResizable(false);
        setTitle("EQUIPMENTS IN ROOM " + room.getNumber());
        
        textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet att = new SimpleAttributeSet();
        StyleConstants.setAlignment(att, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), att, false);
        textPane.setText(room.listOfEquipments());
        try {
            if (room.listOfEquipments().isEmpty())
                textPane.setText("\nThere are no equipments yet!\n");
            else
                textPane.setText(room.listOfEquipments());
        } catch (Exception e) {
            e.printStackTrace();
        }
        textPane.setEditable(false);
        scrollPane = new JScrollPane(textPane);
        
        add(scrollPane);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
