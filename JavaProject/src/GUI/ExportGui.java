/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import CSV.CSVwriter;
import SchoolEquipment.Equipment;
import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author ALJANN
 */
public class ExportGui extends JDialog{
    
    JTextField textField = new JTextField();
    JButton enterButton = new JButton();
    JButton cancelButton = new JButton();
    JLabel label = new JLabel();
    CSVwriter writer = new CSVwriter();
    
    public ExportGui(HashMap<String,Equipment> hash)
    {
        super((java.awt.Frame) null, true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(500,250);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Enter name of the file");
        
        label.setBounds(130,0,300,50);
        label.setText("Enter the name of the file to be exported:");
        label.setForeground(Color.blue);
        
        textField.setBounds(150,50,200,30);
        textField.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (writer.fileExists(textField.getText()))
                    label.setText("File exists already!");
                else
                    label.setText("");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (writer.fileExists(textField.getText()))
                    label.setText("File exists already!");
                else
                    label.setText("");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (writer.fileExists(textField.getText()))
                    label.setText("File exists already!");
                else
                    label.setText("");
            }
            
        });
        try {
            
        } catch (Exception e) {
        }
        
        enterButton.setBounds(125,100,100,35);
        enterButton.setFocusable(false);
        enterButton.setText("Enter");
        cancelButton.setBounds(275,100,100,35);
        cancelButton.setFocusable(false);
        cancelButton.setText("Cancel");
        
        add(label);
        add(textField);
        add(enterButton);
        add(cancelButton);
        setVisible(true);
    }
}
