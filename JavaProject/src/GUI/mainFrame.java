package GUI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author JEM
 */
public class mainFrame {
    JFrame frame = new JFrame();
    
    //panels for frame
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    
    //panels for panel1
    JPanel panelRed1 = new JPanel();
    JPanel panelRed2 = new JPanel();
    
    //buttons
    JButton button1 = new JButton("insert");
    JButton button2 = new JButton("delete");
    JButton button3 = new JButton("replace");
    JButton button4 = new JButton("exit");
    
    //table
//    String[][] sp = {{"101","Computer","Device","Alright","MKT123","5"},
//        {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},
//    {"102", "Projector", "Device", "Needs Replacement", "MKT125", "6"},};
    String[] col = {"ID","Name","Type","Condition","Location","Quantity"};
    String[][] sp = new String[50][col.length];
    
    public mainFrame()
    {
        frame.setLayout(new BorderLayout());
        panel1.setPreferredSize(new Dimension(200,100));
        panel1.setBackground(Color.red);
        panel1.setLayout(new GridLayout(2,1));
        panelRed1.setBackground(Color.MAGENTA);
        panelRed1.setLayout(new GridLayout(4,1,0,5));
        panelRed1.add(button1);
        panelRed1.add(button2);
        panelRed1.add(button3);
        panelRed1.add(button4);
        panelRed1.setBorder(new EmptyBorder(5,5,5,5));
        panelRed2.setBackground(Color.CYAN);
        panel1.add(panelRed1);
        panel1.add(panelRed2);
        
        panel2.setPreferredSize(new Dimension(785,100));
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.BLUE);
        
        for (int i = 0; i < col.length; i++) {
            for (int j = 0; j < 2 ; j++) {
                sp[j][i] = "SAMPLE";
            }
        }
        JTable table = new JTable(sp,col);
        table.setCellSelectionEnabled(true);
        ListSelectionModel lsm = table.getSelectionModel();
        lsm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFillsViewportHeight(true);
        JScrollPane pp = new JScrollPane(table); 
        panel2.add(pp, BorderLayout.WEST);
        
        panel3.setPreferredSize(new Dimension(200,100));
        panel3.setBackground(Color.green);
        
        panel4.setPreferredSize(new Dimension(200,100));
        panel4.setBackground(Color.DARK_GRAY);
        
        frame.add(panel1,BorderLayout.EAST);
        frame.add(panel2,BorderLayout.WEST);
        frame.add(panel3,BorderLayout.SOUTH);
        frame.add(panel4,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1000,600);
        frame.setVisible(true);
    }
    
    
}
