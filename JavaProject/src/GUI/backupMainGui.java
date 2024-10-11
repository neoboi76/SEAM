/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ALJANN
 */
public class backupMainGui {
    
    //initialize image components
    private ImageIcon clearImage = new ImageIcon(getClass().getClassLoader().getResource("Images/clearImageResized.png"));
    private ImageIcon deleteImage = new ImageIcon(getClass().getClassLoader().getResource("Images/deleteImageResized.png"));
    private ImageIcon saveImage = new ImageIcon(getClass().getClassLoader().getResource("Images/saveImageResized.png"));
    private ImageIcon replaceImage = new ImageIcon(getClass().getClassLoader().getResource("Images/replaceImageResized.png"));
    
    private ImageIcon clearImageGlow = new ImageIcon(getClass().getClassLoader().getResource("Images/clearImageGlowResized.png"));
    private ImageIcon deleteImageGlow = new ImageIcon(getClass().getClassLoader().getResource("Images/deleteImageGlowResized.png"));
    private ImageIcon saveImageGlow = new ImageIcon(getClass().getClassLoader().getResource("Images/saveImageGlowResized.png"));
    private ImageIcon replaceImageGlow = new ImageIcon(getClass().getClassLoader().getResource("Images/replaceImageGlowResized.png"));
    
    private ImageIcon clearImageBlack = new ImageIcon(getClass().getClassLoader().getResource("Images/clearImageBlackResized.png"));
    private ImageIcon deleteImageBlack = new ImageIcon(getClass().getClassLoader().getResource("Images/deleteImageBlackResized.png"));
    private ImageIcon saveImageBlack = new ImageIcon(getClass().getClassLoader().getResource("Images/saveImageBlackResized.png"));
    private ImageIcon replaceImageBlack = new ImageIcon(getClass().getClassLoader().getResource("Images/replaceImageBlackResized.png"));
    
    //main JFrame for the main program
    private JFrame guiFrame = new JFrame();
    
    //main buttons for the essential functions of the program
    private JButton clearButton = new JButton(clearImageBlack);
    private JButton deleteButton = new JButton(deleteImageBlack);
    private JButton saveButton = new JButton(saveImageBlack);
    private JButton replaceButton = new JButton(replaceImageBlack);
    
    //JPanels dividing the area inside guiFrame
    private JLayeredPane majorPane = new JLayeredPane();
    
    private JPanel northArea = new JPanel();
    private JPanel eastArea = new JPanel();
    private JPanel eastArea2 = new JPanel();
    private JPanel westArea = new JPanel();
    private JPanel southArea = new JPanel();
    private JPanel extraArea = new JPanel();
    
    //Contents inside the JPanel northArea
    private JPanel northLeftSide = new JPanel();
    private JPanel northCenterSide = new JPanel();
    private JPanel northRightSide = new JPanel();
    private JLabel programTitle = new JLabel();
    
    //JTextField
    private JLabel searchFieldLabel = new JLabel("Search: ");
    private JTextField searchField = new JTextField();
    
    
    //arrays for JTable content
    private String[] columnHeading = {"ID","Name","Type","Condition","Location","Quantity"};
    private String[][] equipmentTableContent = new String[10][10];
    
    //JTable components
    private JTable tb;
    private JScrollPane sp;
    
    //Boolean for the buttons. Checks if a table column is selected.
    private volatile boolean tableSelected = false;
    
    //JFrame constructor
    public backupMainGui()
    {
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setSize(1000,600);
        guiFrame.setLayout(new BorderLayout());
        
        majorPane.setLayout(new BorderLayout());
        
        /*START OF NORTHAREA*/
        northArea.setLayout(new BorderLayout());
        northArea.setBackground(new Color(230, 201, 171));
        northArea.setPreferredSize(new Dimension(100,100));
        
        northCenterSide.setPreferredSize(new Dimension(100,50));
        northCenterSide.setBackground(new Color(230, 201, 171));
        northCenterSide.setBorder(new EmptyBorder(35,10,10,10));
        northCenterSide.setVisible(true);
        
        programTitle.setText("SEAM Project");
        programTitle.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        
        northCenterSide.add(programTitle);
        
        northArea.add(northCenterSide, BorderLayout.CENTER);
        
        guiFrame.add(northArea, BorderLayout.NORTH);
        /*END OF NORTHAREA*/
        
        /*START OF WESTAREA*/
        westArea.setLayout(new BorderLayout());
        westArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
        westArea.setBackground(new Color(246, 231, 216));
        
        tb = new JTable(equipmentTableContent,columnHeading);
        tb.setCellSelectionEnabled(true);
        tb.getTableHeader().setReorderingAllowed(false);
        tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        SwingUtilities.invokeLater(() -> {
            tb.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if (tb.getSelectionModel().isSelectionEmpty() == true)
                {
                    replaceButton.setEnabled(false);
                }
                else                
                {
                    replaceButton.setEnabled(true);
                    replaceButton.setIcon(replaceImage);
                }
            });
        });
        
        SwingUtilities.invokeLater(() -> {
            tb.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if (tb.getSelectionModel().isSelectionEmpty() == true)
                {
                    clearButton.setEnabled(false);
                }
                else                
                {
                    clearButton.setEnabled(true);
                    clearButton.setIcon(clearImage);
                }
            });
        });
        
        SwingUtilities.invokeLater(() -> {
            tb.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if (tb.getSelectionModel().isSelectionEmpty() == true)
                {
                    saveButton.setEnabled(false);
                }
                else                
                {
                    saveButton.setEnabled(true);
                    saveButton.setIcon(saveImage);
                }
            });
        });
        
        SwingUtilities.invokeLater(() -> {
            tb.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if (tb.getSelectionModel().isSelectionEmpty() == true)
                {
                    deleteButton.setEnabled(false);
                }
                else                
                {
                    deleteButton.setEnabled(true);
                    deleteButton.setIcon(deleteImage);
                }
            });
        });
        
        sp = new JScrollPane(tb);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        westArea.add(sp, BorderLayout.CENTER);
        westArea.setSize(300,300);
        westArea.setVisible(true);
        
        majorPane.add(westArea, BorderLayout.CENTER);
        /*END OF WESTAREA*/
        
        /* START OF EASTAREA */
        eastArea.setLayout(new FlowLayout());
        eastArea.setBorder(BorderFactory.createLineBorder(Color.blue));
        eastArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
        eastArea.setBackground(new Color(28, 25, 26));
        eastArea.setPreferredSize(new Dimension(200,200));
        
        replaceButton.setPreferredSize(new Dimension(80,52));
        replaceButton.setDisabledIcon(replaceImageBlack);
        replaceButton.setEnabled(false);
        clearButton.setPreferredSize(new Dimension(80,52));
        clearButton.setDisabledIcon(clearImageBlack);
        clearButton.setEnabled(false);
        saveButton.setPreferredSize(new Dimension(80,52));
        saveButton.setDisabledIcon(saveImageBlack);
        saveButton.setEnabled(false);
        deleteButton.setPreferredSize(new Dimension(80,52));
        deleteButton.setDisabledIcon(deleteImageBlack);
        deleteButton.setEnabled(false);
        
        replaceButton.addMouseListener(new java.awt.event.MouseAdapter()
        {   
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                    replaceButton.setIcon(replaceImageGlow);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                    replaceButton.setIcon(replaceImage);
            }
        });
        
        clearButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                    clearButton.setIcon(clearImageGlow);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                    clearButton.setIcon(clearImage);
            }
        });
        
        saveButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                    saveButton.setIcon(saveImageGlow);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                    saveButton.setIcon(saveImage);
            }
        });
        
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                    deleteButton.setIcon(deleteImageGlow);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                    deleteButton.setIcon(deleteImage);
            }
        });
        
        eastArea.add(replaceButton);
        eastArea.add(clearButton);
        eastArea.add(saveButton);
        eastArea.add(deleteButton);
        
        majorPane.add(eastArea, BorderLayout.EAST);
        
        /*END OF EASTAREA*/
        
        /*START OF EXTRAAREA*/
        extraArea.setLayout(new FlowLayout());
        extraArea.setBorder(BorderFactory.createLineBorder(Color.blue));
        extraArea.setBackground(new Color(28, 25, 26));
        extraArea.setPreferredSize(new Dimension(300,200));
        
        searchField.setPreferredSize(new Dimension(130,30));
        
        searchFieldLabel.setForeground(Color.white);
        
        extraArea.add(searchFieldLabel);
        extraArea.add(searchField);
        
        majorPane.add(extraArea, BorderLayout.WEST);
        /*END OF EXTRAAREA*/
        
        /*START OF SOUTHAREA*/
        southArea.setBackground(new Color(64, 66, 163));
        southArea.setPreferredSize(new Dimension(100,100));
        southArea.setBorder(BorderFactory.createLineBorder(new Color(14, 26, 46), 5));
        
        guiFrame.add(majorPane,BorderLayout.CENTER);
        guiFrame.add(southArea, BorderLayout.SOUTH);   
        /*END OF SOUTHAREA*/
        
        
        guiFrame.setVisible(true);  //set the main frame to visible
        
    }
    
}
