/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ALJANN
 */
public class insertGui extends JDialog {
    JLabel id = new JLabel(), name = new JLabel(), 
            type = new JLabel(), condition = new JLabel(),
            location = new JLabel(), quantity = new JLabel();
    JTextField t1 = new JTextField(), t2 = new JTextField(),
            t3 = new JTextField(), t4 = new JTextField(),
            t5 = new JTextField(), t6 = new JTextField();
    JButton enterButton = new JButton(), cancelButton = new JButton();
    JComboBox equip, locate;
    
    String[] newS;
    
    String[] dropdownEquipment = {"","Printer","Projector","Speakers","Computer","Monitor"};
    String[] dropdownLocation = {"","MKT500","MKT310","MKT602"};
    
    private int num = 6;
    
    public insertGui(MainGui mgui)
    {
        super((java.awt.Frame) null, true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setLayout(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400,400);
        setResizable(false);
        setTitle("Insert a Row");
        
        id.setText("ID: ");
        name.setText("Name: ");
        type.setText("Type: ");
        condition.setText("Condition: ");
        location.setText("Location: ");
        quantity.setText("Quantity: ");
        
        id.setBounds(75,30,60,20);
        t1.setBounds(150,30,150,25);
        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    newS = parseToMainGui();
                    setVisible(false);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Row has been added.");
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                {
                    newS = null;
                    setVisible(false);
                    dispose(); 
                }
            }
        });
        
        name.setBounds(75,70,60,20);
        t2.setBounds(150,70,150,25);
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    newS = parseToMainGui();
                    setVisible(false);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Row has been added.");
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                {
                    newS = null;
                    setVisible(false);
                    dispose(); 
                }
            }
        });
        
        type.setBounds(75,110,60,20);
        equip = new JComboBox<>(dropdownEquipment);
        equip.setBounds(150,110,150,25);
        equip.addItemListener((ItemEvent e) -> {
           t3.setText(String.valueOf(equip.getSelectedItem()));
        });
        
//        type.setBounds(75,110,60,20);
//        t3.setBounds(150,110,150,25);
//        t3.addKeyListener(new java.awt.event.KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER)
//                {
//                    newS = parseToMainGui();
//                    setVisible(false);
//                    dispose();
//                    JOptionPane.showMessageDialog(null, "Row has been added.");
//                }
//                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
//                {
//                    newS = null;
//                    setVisible(false);
//                    dispose(); 
//                }
//            }
//        });
        
        condition.setBounds(75,150,60,20);
        t4.setBounds(150,150,150,25);
        t4.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    newS = parseToMainGui();
                    setVisible(false);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Row has been added.");
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                {
                    newS = null;
                    setVisible(false);
                    dispose(); 
                }
            }
        });
        
        location.setBounds(75,190,60,20);
        locate = new JComboBox<>(dropdownLocation);
        locate.setBounds(150,190,150,25);
        locate.addItemListener((ItemEvent e) -> {
           t5.setText(String.valueOf(locate.getSelectedItem()));
        });
        
//        location.setBounds(75,190,60,20);
//        t5.setBounds(150,190,150,25);
//        t5.addKeyListener(new java.awt.event.KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER)
//                {
//                    newS = parseToMainGui();
//                    setVisible(false);
//                    dispose();
//                    JOptionPane.showMessageDialog(null, "Row has been added.");
//                }
//                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
//                {
//                    newS = null;
//                    setVisible(false);
//                    dispose(); 
//                }
//            }
//        });
        
        quantity.setBounds(75,230,60,20);
        t6.setBounds(150,230,150,25);
        t6.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    newS = parseToMainGui();
                    setVisible(false);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Row has been added.");
                }
                else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    newS = null;
                    setVisible(false);
                    dispose();
                }
            }
        });
        
        enterButton.setFocusable(false);
        enterButton.setText("Enter");
        enterButton.setBounds(60,270,100,25);
        enterButton.addActionListener((ActionEvent e) -> {
            newS = parseToMainGui();
            setVisible(false);
            dispose();
            JOptionPane.showMessageDialog(null, "Row has been added.");
        });
        
        cancelButton.setFocusable(false);
        cancelButton.setText("Cancel");
        cancelButton.setBounds(230,270,100,25);
        cancelButton.addActionListener((ActionEvent e) -> {
            newS = null;
            setVisible(false);
            dispose();
        });
        
        add(id);
        add(t1);
        add(name);
        add(t2);
        add(type);
        add(equip);
        add(condition);
        add(t4);
        add(location);
        add(locate);
        add(quantity);
        add(t6);
        add(enterButton);
        add(cancelButton);
        setLocationRelativeTo(null);
    }
    
    public String[] parseToMainGui()
    {
        String[] s = new String[num];
        JTextField[] t = {t1,t2,t3,t4,t5,t6};
        
        for (int i = 0; i < num; i++)
        {
            s[i] = t[i].getText();
        }
        return s;
    }
}
