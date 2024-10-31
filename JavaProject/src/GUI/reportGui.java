/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import SchoolEquipment.Equipment;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author ALJANN
 */
public class reportGui extends JDialog {
    
    JButton generatePurchase, generateEquipCondition;
    
    public reportGui(HashMap<String,Equipment> h)
    {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400,350);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Report Gui");
        
        generatePurchase = new JButton();
        generateEquipCondition = new JButton();
        
        generatePurchase.setBounds(70, 100, 280, 50);
        generatePurchase.setText("List Of Equipment To Be Purchased");
        generatePurchase.setFocusable(false);
        generatePurchase.addActionListener((e) -> {
            new ReportDefectivesGui(h);
        });
        
        generateEquipCondition.setBounds(70, 200, 280, 50);
        generateEquipCondition.setText("Equipments And Conditions");
        generateEquipCondition.setFocusable(false);
        
        add(generatePurchase);
        add(generateEquipCondition);
        
        
        setVisible(true);
    }
}
