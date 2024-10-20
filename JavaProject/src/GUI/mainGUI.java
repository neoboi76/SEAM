/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import CSV.CSVreader;
import CSV.SingleFileRootViewer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultRowSorter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ALJANN
 */
public class MainGui {
    //initializing CSVreader components
    private CSVreader reader;
    private String file = "src\\sample.csv";
    private String realFile = "";
    
    //initialize image components
    private ImageIcon clearImage = new ImageIcon(getClass().getClassLoader().getResource("Images/clearImageResized.png"));
    private ImageIcon deleteImage = new ImageIcon(getClass().getClassLoader().getResource("Images/deleteImageResized.png"));
    private ImageIcon saveImage = new ImageIcon(getClass().getClassLoader().getResource("Images/saveImageResized.png"));
    private ImageIcon replaceImage = new ImageIcon(getClass().getClassLoader().getResource("Images/replaceImageResized.png"));
    private ImageIcon insertImage = new ImageIcon(getClass().getClassLoader().getResource("Images/insertImageResized.png"));
    
    private ImageIcon clearImageGlow = new ImageIcon(getClass().getClassLoader().getResource("Images/clearImageGlowResized.png"));
    private ImageIcon deleteImageGlow = new ImageIcon(getClass().getClassLoader().getResource("Images/deleteImageGlowResized.png"));
    private ImageIcon saveImageGlow = new ImageIcon(getClass().getClassLoader().getResource("Images/saveImageGlowResized.png"));
    private ImageIcon replaceImageGlow = new ImageIcon(getClass().getClassLoader().getResource("Images/replaceImageGlowResized.png"));
    private ImageIcon insertImageGlow = new ImageIcon(getClass().getClassLoader().getResource("Images/insertImageGlowResized.png"));
    
    private ImageIcon clearImageBlack = new ImageIcon(getClass().getClassLoader().getResource("Images/clearImageBlackResized.png"));
    private ImageIcon deleteImageBlack = new ImageIcon(getClass().getClassLoader().getResource("Images/deleteImageBlackResized.png"));
    private ImageIcon saveImageBlack = new ImageIcon(getClass().getClassLoader().getResource("Images/saveImageBlackResized.png"));
    private ImageIcon replaceImageBlack = new ImageIcon(getClass().getClassLoader().getResource("Images/replaceImageBlackResized.png"));
    private ImageIcon insertImageBlack = new ImageIcon(getClass().getClassLoader().getResource("Images/insertImageBlackResized.png"));
    
    //main JFrame for the main program
    private JFrame guiFrame = new JFrame();
    
    //main buttons for the essential functions of the program
    private JButton clearButton = new JButton(clearImage);
    private JButton deleteButton = new JButton(deleteImage);
    private JButton saveButton = new JButton(saveImage);
    private JButton replaceButton = new JButton(replaceImage);
    private JButton insertButton = new JButton(insertImage);
    private JButton inspectButton = new JButton();
    private JButton newButton = new JButton("new");
    private JButton openButton = new JButton("open");
    private JButton quitButton = new JButton();
    
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
    
    //Contents inside the JPanel extraArea
    private JLabel searchFieldLabel = new JLabel("Search: ");
    private JTextField searchField = new JTextField();
    private JLabel roomsFieldLabel = new JLabel("Rooms: ");
    String[] locations = {"All","MKT500","MKT310","MKT602"};
    private JComboBox roomsDropdown;
    
    //JTable components + additives
    private String[][] normalRowContent = new String[1][1];
    private String[] normalColumnContent = new CSVreader(file).col;
    private JTable tb;
    private JScrollPane sp;
    private DefaultTableModel dtm;
    private TableRowSorter trs;
    
    //JFileChooser + components
    private File root = new File("./src");
    private FileSystemView fsv = new SingleFileRootViewer(root);
    private JFileChooser fileChooser = new JFileChooser(fsv);
    
    //testing panellized button invisible
    private JButton sampleButton = new JButton("sample");
    
    //JFrame constructor
    
    public MainGui()
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
        
        //table generation
        dtm = new DefaultTableModel(normalRowContent,normalColumnContent);
        tb = new JTable(dtm);
        tb.setCellSelectionEnabled(true);
        tb.getTableHeader().setReorderingAllowed(false);
        tb.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tb.setAutoCreateRowSorter(true);
        trs = new TableRowSorter<>(dtm);
        tb.setRowSorter(trs);
        //that's it
        
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
        
        //Start of button characteristics
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
        insertButton.setPreferredSize(new Dimension(80,52));
        insertButton.setDisabledIcon(insertImageBlack);
        newButton.setPreferredSize(new Dimension(80,52));
        //newButton.setDisabledIcon(insertImageBlack);
        openButton.setPreferredSize(new Dimension(80,52));
        //newButton.setDisabledIcon(insertImageBlack);
        //End of button characteristics
        
        SwingUtilities.invokeLater(() -> {
            tb.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if (tb.getSelectionModel().isSelectionEmpty() == true)
                {
                    replaceButton.setEnabled(false);
                    clearButton.setEnabled(false);
                    saveButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                }
                else                
                {
                    replaceButton.setEnabled(true);
                    clearButton.setEnabled(true);
                    saveButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                }
            });
        });
        
        openButton.addActionListener((e) -> {
            int choice = JOptionPane.showConfirmDialog(null, "Open a new .cvs file?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
            {
                int open = fileChooser.showOpenDialog(null);
                String root2;

                if (open == JFileChooser.APPROVE_OPTION)
                {
                    root2 = fileChooser.getSelectedFile().getAbsolutePath();
                    CSVreader reading = new CSVreader(root2);
                    dtm.setRowCount(0);
                    dtm.setDataVector(reading.rows, normalColumnContent);
                }
            }
            
            
        });
        
        newButton.addActionListener((e) -> {
            int choice = JOptionPane.showConfirmDialog(null, "Start a new table?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
            {
                dtm.setRowCount(0);
            }
        });
        
        insertButton.addActionListener((e) -> {
            insertGui ig = new insertGui(this);
            ig.setVisible(true);
            
            if (ig.newS != null)
                dtm.addRow(ig.newS);
        });
        
        //start of button icon listener
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
        
        insertButton.addMouseListener(new java.awt.event.MouseAdapter()
        {   
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                insertButton.setIcon(insertImageGlow);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                insertButton.setIcon(insertImage);
            }
        });
        
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
        //end of button icon listener
        
        deleteButton.addActionListener((ActionEvent e) -> {
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to delete this row?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
            {
                int i = tb.getSelectedRow();
                int j = tb.convertRowIndexToModel(i);
                dtm.removeRow(j);
                deleteButton.setIcon(deleteImage); 
                JOptionPane.showMessageDialog(null, "Row has been deleted.");
            }
            else if (choice == JOptionPane.NO_OPTION)
            { 
                deleteButton.setIcon(deleteImage);
            }
        });
        
        eastArea.add(replaceButton);
        eastArea.add(clearButton);
        eastArea.add(saveButton);
        eastArea.add(deleteButton);
        eastArea.add(insertButton);
        eastArea.add(newButton);
        eastArea.add(openButton);
        majorPane.add(eastArea, BorderLayout.EAST);
        
        /*END OF EASTAREA*/
        
        /*START OF EXTRAAREA*/
        extraArea.setLayout(new FlowLayout());
        extraArea.setBorder(BorderFactory.createLineBorder(Color.blue));
        extraArea.setBackground(new Color(28, 25, 26));
        extraArea.setPreferredSize(new Dimension(250,200));
        
        searchField.setPreferredSize(new Dimension(150,25));
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                search(searchField.getText());
                //printing(searchField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search(searchField.getText());
                //printing(searchField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                search(searchField.getText());
                //printing(searchField.getText());
            }
            public void search(String str)
            {
                if (str.length()==0)
                    trs.setRowFilter(null);
                else
                {
                    trs.setRowFilter(RowFilter.regexFilter("(?i)^"+str));
                    System.out.println(tb.getRowCount());
                }
            }
            public void printing(String str)
            {
                for (int i = 0; i < tb.getRowCount(); i++) 
                    for (int j = 0; j < tb.getColumnCount(); j++)
                    {
                        String faker = (String) dtm.getValueAt(tb.convertRowIndexToModel(i),tb.convertColumnIndexToModel(j)); //jack
                            //faker = faker.substring(0, faker.length()-(faker.length()-str.length()));
                            //dtm.setValueAt(str+(), tb.convertRowIndexToModel(i),tb.convertColumnIndexToModel(j));
                            System.out.println(faker);
  
                    }
            }
            
            
        });
        
        searchFieldLabel.setForeground(Color.white);
        
        roomsDropdown = new JComboBox<>(locations);
        roomsDropdown.setPreferredSize(new Dimension(150,25));
        roomsDropdown.addItemListener((ItemEvent e) -> {
            if (null != String.valueOf(roomsDropdown.getSelectedItem()))
                switch (String.valueOf(roomsDropdown.getSelectedItem())) {
                    case "All" -> trs.setRowFilter(null);
                    case "MKT500" -> trs.setRowFilter(RowFilter.regexFilter("MKT500"));
                    case "MKT310" -> trs.setRowFilter(RowFilter.regexFilter("MKT310"));
                    case "MKT602" -> trs.setRowFilter(RowFilter.regexFilter("MKT602"));
                    default -> {
                }
                }
        });
        
        roomsFieldLabel.setForeground(Color.white);
        
        extraArea.add(searchFieldLabel);
        extraArea.add(searchField);
        extraArea.add(roomsFieldLabel);
        extraArea.add(roomsDropdown);
        
        majorPane.add(extraArea, BorderLayout.WEST);
        /*END OF EXTRAAREA*/
        
        /*START OF SOUTHAREA*/
        southArea.setBackground(new Color(64, 66, 163));
        southArea.setPreferredSize(new Dimension(100,100));
        southArea.setBorder(BorderFactory.createLineBorder(new Color(14, 26, 46), 5));
        
        guiFrame.add(majorPane,BorderLayout.CENTER);
        guiFrame.add(southArea, BorderLayout.SOUTH);   
        /*END OF SOUTHAREA*/
        
        guiFrame.setLocationRelativeTo(null);
        guiFrame.setVisible(true);  //set the main frame to visible
        
    }
    
    
    public void changeToTable()
    {
        
    }
}
