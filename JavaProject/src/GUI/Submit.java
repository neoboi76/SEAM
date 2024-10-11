/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ALJANN
 */
public class Submit implements ActionListener, KeyListener {
    
    private JTextField txt;
    private JPasswordField pass;
    private JLabel label;
    private String name;
    private String ps;
    private volatile int num;
    private boolean bool;
    
    public Submit()
    {
        
    }
    
    public Submit(JTextField txt,JPasswordField pass, JLabel label, String name,String ps, int num, boolean bool)
    {
        this.txt = txt;
        this.pass = pass;
        this.label = label;
        this.name = name;
        this.ps = ps;
        this.num = num;
        this.bool = bool;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
 
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public int changeValue(int i)
    {
        i = this.num;
        return i;
    }
    public boolean returnTrue(boolean bool)
    {
        bool = this.bool;
        return bool;
    }
    
}
