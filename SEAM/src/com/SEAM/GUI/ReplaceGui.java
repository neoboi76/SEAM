/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SEAM.GUI;

import com.SEAM.SEAMImplements.ReferenceObject;
import com.SEAM.SchoolEquipment.Equipment;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author ALJANN
 */
public class ReplaceGui extends JDialog{
    
    JLabel id = new JLabel(), name = new JLabel(),
            type = new JLabel(), condition = new JLabel(),
            location = new JLabel(), quantity = new JLabel(), warningLabel = new JLabel();
    JTextField t1 = new JTextField(), t2 = new JTextField(),
            t3 = new JTextField(), t4 = new JTextField(),
            t5 = new JTextField(), t6 = new JTextField();
    JButton enterButton = new JButton(), cancelButton = new JButton();
    JComboBox equip, locate, condi;

    String[] newS;

    String[] dropdownEquipment = ReferenceObject.getEqList();
    String[] dropdownLocation = ReferenceObject.getRoomList();
    String[] dropdownCondition = ReferenceObject.getCondiList();

    private int num = 6;

    public ReplaceGui(MainGui mgui, HashMap<String, Equipment> hm, String[] deets) {
        super((java.awt.Frame) null, true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setLayout(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setTitle("Replace a Row");

        warningLabel.setText("");
        warningLabel.setForeground(Color.red);
        warningLabel.setFont(new Font(warningLabel.getFont().getName(), warningLabel.getFont().getStyle(), 10));
        warningLabel.setBounds(150, -10, 150, 50);

        id.setText("ID: ");
        name.setText("Name: ");
        type.setText("Type: ");
        condition.setText("Condition: ");
        location.setText("Location: ");
        quantity.setText("Quantity: ");

        id.setBounds(75, 30, 60, 20);
        t1.setBounds(150, 30, 150, 25);
        t1.setText(deets[0]);
        t1.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText()) && checkTextFieldsNotEmpty()) {
                    warningLabel.setText("");
                    enterButton.setEnabled(true);
                } else {
                    if (!checkDuplicate(hm, t1.getText())) {
                        warningLabel.setText("Duplicate ID");
                    } else if (!checkIfNotNumber(t1.getText()) && !t1.getText().isEmpty()) {
                        warningLabel.setText("ID can only contain numbers");
                    } else {
                        warningLabel.setText("");
                    }
                    enterButton.setEnabled(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText()) && checkTextFieldsNotEmpty()) {
                    warningLabel.setText("");
                    enterButton.setEnabled(true);
                } else {
                    if (!checkDuplicate(hm, t1.getText())) {
                        warningLabel.setText("Duplicate ID");
                    } else if (!checkIfNotNumber(t1.getText()) && !t1.getText().isEmpty()) {
                        warningLabel.setText("ID can only contain numbers");
                    } else {
                        warningLabel.setText("");
                    }
                    enterButton.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText()) && checkTextFieldsNotEmpty()) {
                    warningLabel.setText("");
                    enterButton.setEnabled(true);
                } else {
                    if (!checkDuplicate(hm, t1.getText())) {
                        warningLabel.setText("Duplicate ID");
                    } else if (!checkIfNotNumber(t1.getText()) && !t1.getText().isEmpty()) {
                        warningLabel.setText("ID can only contain numbers");
                    } else {
                        warningLabel.setText("");
                    }
                    enterButton.setEnabled(false);

                }
            }

        });

        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText()) && checkTextFieldsNotEmpty() && (e.getKeyCode() == KeyEvent.VK_ENTER)) {
                    newS = parseToMainGui();
                    setVisible(false);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Row has been added.");
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    newS = null;
                    setVisible(false);
                    dispose();
                }
            }
        });

        name.setBounds(75, 70, 60, 20);
        t2.setBounds(150, 70, 150, 25);
        t2.setText(deets[1]);
        t2.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (checkTextFieldsNotEmpty() && checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText())) {
                    warningLabel.setText("");
                    enterButton.setEnabled(true);
                } else {
                    enterButton.setEnabled(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (checkTextFieldsNotEmpty() && checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText())) {
                    warningLabel.setText("");
                    enterButton.setEnabled(true);
                } else {
                    enterButton.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (checkTextFieldsNotEmpty() && checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText())) {
                    warningLabel.setText("");
                    enterButton.setEnabled(true);
                } else {
                    enterButton.setEnabled(false);
                }
            }

        });
        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText()) && checkTextFieldsNotEmpty() && (e.getKeyCode() == KeyEvent.VK_ENTER)) {
                    newS = parseToMainGui();
                    setVisible(false);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Row has been added.");
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    newS = null;
                    setVisible(false);
                    dispose();
                }
            }
        });

        type.setBounds(75, 110, 60, 20);
        equip = new JComboBox<>(dropdownEquipment);
        equip.setBounds(150, 110, 150, 25);
        equip.addItemListener((ItemEvent e) -> {
            t3.setText(String.valueOf(equip.getSelectedItem()));
            if (checkTextFieldsNotEmpty() && checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText())) {
                warningLabel.setText("");
                enterButton.setEnabled(true);
            } else {

                enterButton.setEnabled(false);
            }
        });

        condition.setBounds(75, 150, 60, 20);
        condi = new JComboBox<>(dropdownCondition);
        condi.setBounds(150, 150, 150, 25);
        condi.addItemListener((ItemEvent e) -> {
            t4.setText(String.valueOf(condi.getSelectedItem()));
            if (checkTextFieldsNotEmpty() && checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText())) {
                warningLabel.setText("");
                enterButton.setEnabled(true);
            } else {

                enterButton.setEnabled(false);
            }
        });

        location.setBounds(75, 190, 60, 20);
        locate = new JComboBox<>(dropdownLocation);
        locate.setBounds(150, 190, 150, 25);
        locate.addItemListener((ItemEvent e) -> {
            t5.setText(String.valueOf(locate.getSelectedItem()));
            if (checkTextFieldsNotEmpty() && checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText())) {
                warningLabel.setText("");
                enterButton.setEnabled(true);
            } else {

                enterButton.setEnabled(false);
            }
        });

        quantity.setBounds(75, 230, 60, 20);
        t6.setBounds(150, 230, 150, 25);
        t6.setText(deets[5]);
        t6.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (checkTextFieldsNotEmpty() && checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText())) {
                    warningLabel.setText("");
                    enterButton.setEnabled(true);
                } else {

                    enterButton.setEnabled(false);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (checkTextFieldsNotEmpty() && checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText())) {
                    warningLabel.setText("");
                    enterButton.setEnabled(true);
                } else {

                    enterButton.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (checkTextFieldsNotEmpty() && checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText())) {
                    warningLabel.setText("");
                    enterButton.setEnabled(true);
                } else {

                    enterButton.setEnabled(false);
                }
            }

        });
        t6.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (checkIfNotNumber(t1.getText()) && checkDuplicate(hm, t1.getText()) && checkTextFieldsNotEmpty() && (e.getKeyCode() == KeyEvent.VK_ENTER)) {
                    newS = parseToMainGui();
                    setVisible(false);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Row has been added.");
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    newS = null;
                    setVisible(false);
                    dispose();
                }
            }
        });

        enterButton.setEnabled(false);
        enterButton.setFocusable(false);
        enterButton.setText("Enter");
        enterButton.setBounds(60, 270, 100, 25);
        enterButton.addActionListener((ActionEvent e) -> {
            newS = parseToMainGui();
            setVisible(false);
            dispose();
            JOptionPane.showMessageDialog(null, "Row has been added.");
        });

        cancelButton.setFocusable(false);
        cancelButton.setText("Cancel");
        cancelButton.setBounds(230, 270, 100, 25);
        cancelButton.addActionListener((ActionEvent e) -> {
            newS = null;
            setVisible(false);
            dispose();
        });

        add(warningLabel);
        add(id);
        add(t1);
        add(name);
        add(t2);
        add(type);
        add(equip);
        add(condition);
        add(condi);
        add(location);
        add(locate);
        add(quantity);
        add(t6);
        add(enterButton);
        add(cancelButton);
        setLocationRelativeTo(null);
    }

    /**
     * Collects the String inputs from the Input GUI and passes them back to the
     * Main GUI for further usage.
     *
     *
     * @return String[] = returns the array of String schema for the row index
     */
    public String[] parseToMainGui() {
        String[] s = new String[num];
        JTextField[] t = {t1, t2, t3, t4, t5, t6};

        for (int i = 0; i < num; i++) {
            s[i] = t[i].getText();
        }
        return s;
    }

    /**
     * Checks if the String input already exists in the hashmap of table data.
     *
     * @param eq
     * @param update
     * @return false = if duplicate exists
     *
     */
    public boolean checkDuplicate(HashMap<String, Equipment> eq, String update) {
        for (Map.Entry<String, Equipment> it : eq.entrySet()) {
            if (it.getKey().contentEquals(update)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the ID string has non-numerical characters. ID can only be
     * written as a numerical string.
     *
     * @param update
     * @return false = if there are non-numerical characters in the string
     */
    public boolean checkIfNotNumber(String update) {
        String regex = "[0-9]+";
        return update.matches(regex);
    }

    /**
     * Checks if the input fields are empty or not.
     *
     * @return false = if one or more fields are empty
     */
    public boolean checkTextFieldsNotEmpty() {
        JTextField[] t = {t1, t2, t3, t4, t5, t6};
        for (JTextField text : t) {
            if (text.getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
