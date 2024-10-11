/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.adminName to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author ALJANN
 */
public class loginGUI{
    //account log in before accessing the mainGUI
    
    private JFrame frame = new JFrame();
    private JTextField adminName = new JTextField();
    private JPasswordField adminPassword = new JPasswordField();
    private JLabel textName = new JLabel();
    private JLabel textPass = new JLabel();
    private JLabel loginMessage = new JLabel();
    private JButton enterButton = new JButton();
    private JButton cancelButton = new JButton();
    
    private String correctName;
    private String correctPass;
    
    private static volatile int tries = 3;
    private static volatile boolean correct = false;
    
    public loginGUI()
    {
        correctName = "admin";
        correctPass = "pass";
        
        textName.setText("Enter Name: ");
        textName.setBounds(100,20,100,50); 
        textName.setVisible(true);
        
        adminName.setBounds(225,34,150,25); //add size + label1.setBounds
        adminName.addKeyListener(new Submit(adminName, adminPassword, loginMessage, correctName, correctPass, tries, correct)
        {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    if (adminName.getText().toLowerCase().equals(correctName) &&
                            String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass))
                    {
                        loginMessage.setText("CORRECT DETAILS NIGGA");
                        loginMessage.setVisible(true);
                        correct = true;
                    }
                    else if (tries == 0)
                    {
                        loginMessage.setText("Go fuck yourself");
                        loginMessage.setVisible(true);
                    }
                    else if (adminName.getText().isEmpty() && 
                            String.valueOf(adminPassword.getPassword()).isEmpty())
                    {
                        loginMessage.setText("ENTER DETAILS NUMBNUTS");
                        loginMessage.setVisible(true);
                    }
                    else if ((!adminName.getText().isEmpty() && 
                            !String.valueOf(adminPassword.getPassword()).isEmpty()) &&
                            (!adminName.getText().toLowerCase().equals(correctName) &&
                            !String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass)))
                    {
                        loginMessage.setText("WRONG DETAILS NIGGER");
                        loginMessage.setVisible(true);
                        tries--;
                    }
                    else if (adminName.getText().toLowerCase().equals(correctName) &&
                            !String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass))
                    {
                        loginMessage.setText("WHAT THE FUCK IS THIS PASSWORD???");
                        loginMessage.setVisible(true);
                        tries--;
                    }
                    else if (!adminName.getText().toLowerCase().equals(correctName) &&
                            String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass))
                    {
                        loginMessage.setText("UNKNOWN NAME BOZO");
                        loginMessage.setVisible(true);
                        tries--;
                    }
                }
            }
            
        });

        textPass.setText("Enter Password: ");
        textPass.setBounds(100,50,100,50); // plus 4
        textPass.setVisible(true);
        
        adminPassword.setBounds(225,64,150,25);
        adminPassword.addKeyListener(new Submit(adminName, adminPassword, loginMessage, correctName, correctPass, tries, correct)
        {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    if (adminName.getText().toLowerCase().equals(correctName) &&
                            String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass))
                    {
                        loginMessage.setText("CORRECT DETAILS NIGGA");
                        loginMessage.setVisible(true);
                        enterButton.setEnabled(false);
                        cancelButton.setEnabled(false);
                        correct = true;
                    }
                    else if (tries == 0)
                    {
                        loginMessage.setText("Go fuck yourself");
                        loginMessage.setVisible(true);
                    }
                    else if (adminName.getText().isEmpty() && 
                            String.valueOf(adminPassword.getPassword()).isEmpty())
                    {
                        loginMessage.setText("ENTER DETAILS NUMBNUTS");
                        loginMessage.setVisible(true);
                    }
                    else if ((!adminName.getText().isEmpty() && 
                            !String.valueOf(adminPassword.getPassword()).isEmpty()) &&
                            (!adminName.getText().toLowerCase().equals(correctName) &&
                            !String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass)))
                    {
                        loginMessage.setText("WRONG DETAILS NIGGER");
                        loginMessage.setVisible(true);
                        tries--;
                    }
                    else if (adminName.getText().toLowerCase().equals(correctName) &&
                            !String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass))
                    {
                        loginMessage.setText("WHAT THE FUCK IS THIS PASSWORD???");
                        loginMessage.setVisible(true);
                        tries--;
                    }
                    else if (!adminName.getText().toLowerCase().equals(correctName) &&
                            String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass))
                    {
                        loginMessage.setText("UNKNOWN NAME BOZO");
                        loginMessage.setVisible(true);
                        tries--;
                    }
                }
            }   
        });
        
        loginMessage.setForeground(Color.red);
        loginMessage.setBounds(180,-1,300,50); // plus 4
        loginMessage.setVisible(false);
        
        enterButton.setFocusable(false);
        enterButton.setText("Enter");
        enterButton.setBounds(135, 100, 100, 30);
        enterButton.addActionListener(new Submit(adminName, adminPassword, loginMessage, correctName, correctPass, tries, correct)
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (adminName.getText().toLowerCase().equals(correctName) &&
                            String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass))
                    {
                        loginMessage.setText("CORRECT DETAILS NIGGA");
                        loginMessage.setVisible(true);
                        enterButton.setEnabled(false);
                        cancelButton.setEnabled(false);
                        correct = true;
                    }
                    else if (tries == 0)
                    {
                        loginMessage.setText("Go fuck yourself");
                        loginMessage.setVisible(true);
                    }
                    else if (adminName.getText().isEmpty() && 
                            String.valueOf(adminPassword.getPassword()).isEmpty())
                    {
                        loginMessage.setText("ENTER DETAILS NUMBNUTS");
                        loginMessage.setVisible(true);
                    }
                    else if ((!adminName.getText().isEmpty() && 
                            !String.valueOf(adminPassword.getPassword()).isEmpty()) &&
                            (!adminName.getText().toLowerCase().equals(correctName) &&
                            !String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass)))
                    {
                        loginMessage.setText("WRONG DETAILS NIGGER");
                        loginMessage.setVisible(true);
                        tries--;
                    }
                    else if (adminName.getText().toLowerCase().equals(correctName) &&
                            !String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass))
                    {
                        loginMessage.setText("WHAT THE FUCK IS THIS PASSWORD???");
                        loginMessage.setVisible(true);
                        tries--;
                    }
                    else if (!adminName.getText().toLowerCase().equals(correctName) &&
                            String.valueOf(adminPassword.getPassword()).toLowerCase().equals(correctPass))
                    {
                        loginMessage.setText("UNKNOWN NAME BOZO");
                        loginMessage.setVisible(true);
                        tries--;
                    }
                }
        });
        
        cancelButton.setFocusable(false);
        cancelButton.setText("Cancel");
        cancelButton.setBounds(255, 100, 100, 30);
        cancelButton.addActionListener((e)-> System.exit(0));
        
        
        frame.add(adminName);
        frame.add(textName);
        frame.add(adminPassword);
        frame.add(textPass);
        frame.add(enterButton);
        frame.add(cancelButton);
        frame.add(loginMessage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Log-in");
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    public int checkStatus()
    {
        return tries;
    }
    
    public boolean shutdown(int tries)
    {
        return tries != 0;
    }

    public static int getTries() {
        return tries;
    }

    public JFrame getFrame() {
        return frame;
    }

    public boolean isCorrect() {
        return correct;
    }
   
}
