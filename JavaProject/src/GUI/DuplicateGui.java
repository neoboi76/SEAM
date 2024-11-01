/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import SchoolEquipment.Equipment;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author ALJANN
 */
public class DuplicateGui extends JDialog {
    JButton okayButton;
    JLabel enterAmount;
    JLabel isIdSame;
    JPanel display;
    JButton button;
    JTextField textField;
    JTextArea textArea;
    JTextPane textPane;
    JScrollPane scrollPane;
    String collectRooms = "";
    String collectDuplicates = "";
    
    
    
    
    public DuplicateGui(HashMap<String,Equipment> hm, Equipment equip, String maxKey)
    {   
        super((java.awt.Frame) null, true);
        setLayout(null);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400,200);
        setResizable(false);
        setTitle("Duplicate an equipment");
        
        enterAmount = new JLabel();
        enterAmount.setText("Enter amount of duplications:");
        enterAmount.setBounds(120,0,200,30);
        
        textField = new JTextField();
        textField.setBounds(150,30,100,30);
        textField.getDocument().addDocumentListener((new javax.swing.event.DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        }));
        
        isIdSame = new JLabel();
        isIdSame.setText("");
        isIdSame.setBounds(120, 60, 200, 30);
        
        okayButton = new JButton();
        okayButton.setBounds(150, 80, 100, 35);
        okayButton.setText("Enter");
        
        
//        textPane = new JTextPane();
//        StyledDocument doc = textPane.getStyledDocument();
//        SimpleAttributeSet att = new SimpleAttributeSet();
//        StyleConstants.setAlignment(att, StyleConstants.ALIGN_CENTER);
//        doc.setParagraphAttributes(0, doc.getLength(), att, false);
//        textPane.setText(room.listOfEquipments());
//        textPane.setEditable(false);
//        scrollPane = new JScrollPane(textPane);
        add(enterAmount);
        add(textField);
        add(isIdSame);
        add(okayButton);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void copyMachine(int numbers, String maxKey, Equipment equip)
    {
        int newNumber = Integer.valueOf(maxKey);
        for(int i = 0; i < numbers ; i++)
        {
            
        }
    }
}
