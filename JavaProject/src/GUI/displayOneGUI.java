/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ALJANN
 */
public class displayOneGUI {
    JFrame frame = new JFrame();
    JLabel label = new JLabel();

    public displayOneGUI(mainGUI main) {
        label.setText("Hello bitches");
        label.setBounds(300,300,0,0);
        
        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new Dimension(300,250));
        frame.setVisible(true);
    }
    
    
}
