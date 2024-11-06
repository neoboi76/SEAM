/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SEAM.GUI;

import com.SEAM.SchoolEquipment.Equipment;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author ALJANN
 */
public class ReportPopupGui extends JDialog {
    
    JButton generatePurchase, generateEquipCondition;
    
    public ReportPopupGui(HashMap<String,Equipment> h)
    {
        super((java.awt.Frame) null, true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400,350);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Report Gui");
        
        generatePurchase = new JButton();
        generateEquipCondition = new JButton();
        
        generatePurchase.setBounds(60, 70, 280, 50);
        generatePurchase.setText("List Of Equipment To Be Purchased");
        generatePurchase.setFocusable(false);
        generatePurchase.addActionListener((e) -> {
            new ReportDefectivesGui(h);
        });
        
        generateEquipCondition.setBounds(60, 170, 280, 50);
        generateEquipCondition.setText("Equipments And Conditions");
        generateEquipCondition.setFocusable(false);
        generateEquipCondition.addActionListener((e) -> {
            new EquipmentConditionGui(h);
        });
        
        add(generatePurchase);
        add(generateEquipCondition);
        
        
        setVisible(true);
    }
}
