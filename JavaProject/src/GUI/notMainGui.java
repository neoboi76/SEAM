/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ALJANN
 */
public class notMainGui implements ActionListener, KeyListener {
    private JFrame frame = new JFrame();
    private JButton button = new JButton();
    private JButton button2 = new JButton();
    private JLabel label = new JLabel();
    public displayOneGUI displayStats;
    
    public notMainGui()
    {
        label.setBounds(200,200,150,50);
        label.setBackground(Color.red);
        label.setOpaque(true);
        label.setVisible(true);
        
        button.setBounds(100,100,50,25);
        button.setFocusable(false);
        button.setText("Yo");
        button.setVisible(true);
        button.addActionListener(
                (e) -> displayStats = new displayOneGUI(this)
        );
        
        button2.setBounds(300,150,50,25);
        button2.setFocusable(false);
        button2.setText("here");
        button2.setVisible(true);
        button2.addActionListener(
                (e) -> label.setText("Fucking stop clicking here") //stop
        );
        
        frame.add(button);
        frame.add(button2);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MAPUA SEAM");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.getContentPane().setBackground(new Color(81,107,201));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
