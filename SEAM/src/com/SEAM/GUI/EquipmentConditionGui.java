/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SEAM.GUI;

import com.SEAM.CSV.CSVwriter;
import com.SEAM.SEAMImplements.ReferenceObject;
import com.SEAM.SchoolEquipment.Equipment;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;
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
import java.time.*;

/**
 *
 * @author ALJANN
 */
public class EquipmentConditionGui extends JDialog{
    FileWriter fw;
    File folder = new File("./src");
    File[] files = folder.listFiles();
    CSVwriter writer = new CSVwriter();
    JButton okayButton;
    JLabel reportFailures;
    JPanel buttonPanel;
    JPanel display;
    JTextArea textArea;
    JTextPane textPane;
    JScrollPane scrollPane;
    String collectDetails = "";
    int defectCount = 0;

    private String[] equipment = ReferenceObject.getEqList();
    private String[] location = ReferenceObject.getRoomList();
    private String[] condition = {"Needs Replacement", "Missing", "Disposed"};

    public EquipmentConditionGui(HashMap<String, Equipment> h) {
        super((java.awt.Frame) null, true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setResizable(false);
        setTitle("EQUIPMENT AND CONDITIONS");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        try {
            int increase = 1;
            for (Map.Entry<String, Equipment> m : h.entrySet()) {
                collectDetails += (increase++) + ". " + m.getValue().getName() + "\nCondition: "
                        + m.getValue().getCondition() + "\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        textPane = new JTextPane();
//        textPane.setPreferredSize(new Dimension(200,200));
        scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension(400,300));
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet att = new SimpleAttributeSet();
        StyleConstants.setAlignment(att, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), att, false);
        textPane.setText(collectDetails);
        textPane.setEditable(false);
        
        
        display = new JPanel();
        display.setPreferredSize(new Dimension(300,400));
        
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(300,200));
        
        okayButton = new JButton(); 
        okayButton.setText("export");
        okayButton.addActionListener((e) -> {
            try {
//                LocalDateTime ldt = LocalDateTime.now();
                LocalDate ldt = LocalDate.now();

                fw = new FileWriter("src/" + "Equipment Details Report " + ldt + ".txt");
                fw.write(collectDetails);
                fw.close();
            } catch (Exception a) {
                a.printStackTrace();
            }
        });
        
        display.add(scrollPane);
        buttonPanel.add(okayButton);
        
        add(display);
        add(buttonPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
