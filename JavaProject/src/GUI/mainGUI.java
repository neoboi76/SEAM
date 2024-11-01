/**
*   MainGui is a JFrame container which acts as the main Graphical User Interface (GUI)
*   For this SEAM project. MainGui acts upon a Singleton design pattern aka it is
*   only instantiated once.
*
*
*
*/
package GUI;

import CSV.CSVreader;
import CSV.CSVwriter;
import CSV.SingleFileRootViewer;
import SchoolEquipment.Equipment;
import SchoolEquipment.EquipmentFactory;
import SchoolRooms.ComputerLab;
import SchoolRooms.DrawingRoom;
import SchoolRooms.Room;
import SchoolRooms.RoomPopulation;
import SchoolRooms.StandardClassroom;
import SeamImplements.ReferenceObject;
import TestPackage.ButtonImage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ALJANN
 */
public class MainGui {
    //initializing CSVreader components
    private CSVreader reader;
    private CSVwriter writer = new CSVwriter();
    private String file = "src\\sample.csv";
    private String realFile = "";
    private String openedFile = "";
    
    //initializing factory design patterns
    EquipmentFactory ef = new EquipmentFactory();
    RoomPopulation rp = new RoomPopulation();
    
    //initializing rooms
    StandardClassroom MKT310 = new StandardClassroom("MKT310", "310", "3", 100);
    DrawingRoom MKT500 = new DrawingRoom("MKT500","500","5",100);
    ComputerLab MKT602 = new ComputerLab("MKT602","602","6",100);
    private Room[] activeRooms = {MKT500,MKT310,MKT602};
    
    //temp equipment arraylist
    private ArrayList<Equipment> eq = new ArrayList<>();
    
    //equipment hashmap<equipment id, equipment>
    private HashMap<String,Equipment> equipmentHashmap = new HashMap<>();
    
    //initialize image components
    private ButtonImage clear = new ButtonImage("src/Images/clearImageResized.png","src/Images/clearImageGlowResized.png","src/Images/clearImageBlackResized.png");
    private ButtonImage delete = new ButtonImage("src/Images/deleteImageResized.png","src/Images/deleteImageGlowResized.png","src/Images/deleteImageBlackResized.png");
    private ButtonImage save = new ButtonImage("src/Images/saveImageResized.png","src/Images/saveImageGlowResized.png","src/Images/saveImageBlackResized.png");
    private ButtonImage replace = new ButtonImage("src/Images/replaceImageResized.png","src/Images/replaceImageGlowResized.png","src/Images/replaceImageBlackResized.png");
    private ButtonImage insert = new ButtonImage("src/Images/insertImageResized.png","src/Images/insertImageGlowResized.png","src/Images/insertImageBlackResized.png");
    private ButtonImage export = new ButtonImage("src/Images/exportImageResized.png","src/Images/exportImageGlowResized.png","src/Images/exportImageBlackResized.png");    
    private ButtonImage neww = new ButtonImage("src/Images/newImageResized.png","src/Images/newImageGlowResized.png","src/Images/newImageBlackResized.png");    
    private ButtonImage open = new ButtonImage("src/Images/openImageResized.png","src/Images/openImageGlowResized.png","src/Images/openImageBlackResized.png");    
    private ButtonImage report = new ButtonImage("src/Images/reportImageResized.png","src/Images/reportImageGlowResized.png","src/Images/reportImageBlackResized.png");    
    private ButtonImage duplicate = new ButtonImage("src/Images/duplicateImageResized.png","src/Images/duplicateImageGlowResized.png","src/Images/duplicateImageBlackResized.png");    
    
    //main JFrame for the main program
    private JFrame guiFrame = new JFrame();
    
    //JFrame icon
    private ImageIcon frameIcon = new ImageIcon("src/Images/dtimbol.jpg");
    
    //main buttons for the essential functions of the program
    //also inside eastarea
    private JButton clearButton = new JButton(clear.getOriginal());
    private JButton deleteButton = new JButton(delete.getOriginal());
    private JButton saveButton = new JButton(save.getOriginal());
    private JButton replaceButton = new JButton(replace.getOriginal());
    private JButton insertButton = new JButton(insert.getOriginal());
    private JButton newButton = new JButton(neww.getOriginal());
    private JButton openButton = new JButton(open.getOriginal());
    private JButton reportButton = new JButton(report.getOriginal());
    private JButton exportButton = new JButton(export.getOriginal());
    private JButton quitButton = new JButton();
    private JButton duplicateButton = new JButton(duplicate.getOriginal());
    
    private JPanel eastOne = new JPanel();
    private JPanel eastTwo = new JPanel();
    private JPanel eastThree = new JPanel();
    private JPanel eastThreeOne = new JPanel();
    private JPanel eastThreeTwo = new JPanel();
    
    private JButton[] buttons = {clearButton,deleteButton, saveButton, replaceButton,insertButton,exportButton};
    
    //JPanels dividing the area inside guiFrame
    private JLayeredPane majorPane = new JLayeredPane();
    
    private JPanel northArea = new JPanel();
    private JPanel eastArea = new JPanel();
    private JPanel eastArea2 = new JPanel();
    private JPanel westArea = new JPanel();
    private JPanel southArea = new JPanel();
    private JPanel extraArea = new JPanel();
    
    
    //extraArea panels and additives
    private JPanel rowFilterTitle = new JPanel();
    private JPanel rowSearch = new JPanel();
    private JPanel rowFilt = new JPanel();
    private JPanel rowDisplay = new JPanel();
    private JPanel extraAreaLabel = new JPanel();
    private JLabel labelFilters = new JLabel();
    
    //Contents inside the JPanel northArea
    private JPanel northLeftSide = new JPanel();
    private JPanel northCenterSide = new JPanel();
    private JPanel northRightSide = new JPanel();
    private JLabel programTitle = new JLabel();
    private JLabel logoNorth = new JLabel(new ImageIcon("src/Images/logoNorthResized.png"));
    
    //Contents inside the JPanel extraArea
    String[] locations = {"All", "MKT500", "MKT310", "MKT602"};
    String[] equipments = {"All", "Printer", "Projector", "Speakers", "Smartboard", "Tablet"};
    String[] colFilters = {"All", "ID","Name","Type","Condition","Location","Quantity"};
    
    private JTextField searchField = new JTextField();
    private JLabel searchFieldLabel = new JLabel("Search: ");
    private JLabel roomsFieldLabel = new JLabel("Rooms: ");
    private JLabel equipmentsFieldLabel = new JLabel("Type:     ");
    private JLabel columnsFieldLabel = new JLabel("Column: ");
    private JLabel filtersForSearch = new JLabel("Filter By Search");
    private JLabel filtersTypeEquip = new JLabel("Filter by Room/Type");
    private JLabel displayByRoom = new JLabel("Show Items in Room:");
    private JRadioButton r1 = new JRadioButton();
    private JRadioButton r2 = new JRadioButton();
    private JRadioButton r3 = new JRadioButton();
    private JButton displayRoomButton = new JButton("Display");
    private ButtonGroup bg = new ButtonGroup();
    private JComboBox roomDropdown;
    private JComboBox equipmentDropdown;
    private JComboBox columnDropdown;
    
    //Contents inside the JPanel southarea
    private JLabel credits = new JLabel();
    private JLabel updateLabel = new JLabel();
    private JPanel southFirstHalf = new JPanel();
    private JPanel southSecondHalf = new JPanel();
    private int roomNumber;
    
    //JTable components + additives
    private String[][] normalRowContent = new String[0][0];
    private String[] normalColumnContent = ReferenceObject.standardCol;
    private JTable tb;
    private JScrollPane sp;
    private DefaultTableModel dtm;
    private TableRowSorter<DefaultTableModel> trs;
    private ArrayList<RowFilter<Object,Object>> filters = new ArrayList<>(3);
    private RowFilter<Object,Object> mainFilter;
    
    //JFileChooser + components
    private File root = new File("./src");
    private FileSystemView fsv = new SingleFileRootViewer(root);
    private JFileChooser fileChooser = new JFileChooser(fsv);
    private FileNameExtensionFilter allowedFiles = new FileNameExtensionFilter("Comma Separated Values", "csv");
    
    //JFrame constructor
    public MainGui()
    {
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setSize(1000,600);
        guiFrame.setLayout(new BorderLayout());
        guiFrame.setIconImage(frameIcon.getImage());
        
        majorPane.setLayout(new BorderLayout());
        
        /*START OF NORTHAREA*/
        northArea.setLayout(new BorderLayout());
        northArea.setBackground(new Color(230, 201, 171));
        //northArea.setPreferredSize(new Dimension(100,100));
        
        northCenterSide.setPreferredSize(new Dimension(100,100));
        //northCenterSide.setLayout(null);
        northCenterSide.setBackground(new Color(230, 201, 171));
        northCenterSide.setVisible(true);
        
        //logoNorth.setBounds(200, 0, 200, 200);
        
        northCenterSide.add(logoNorth);
        
        northArea.add(northCenterSide, BorderLayout.CENTER);
        
        guiFrame.add(northArea, BorderLayout.NORTH);
        /*END OF NORTHAREA*/
        
        /*START OF WESTAREA*/
        westArea.setLayout(new BorderLayout());
        westArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
        westArea.setBackground(new Color(246, 231, 216));
        westArea.setPreferredSize(new Dimension(300, 300));
//        westArea.setMinimumSize(new Dimension(50, 50));
//        westArea.setMaximumSize(new Dimension(300, 300));
        
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
        
        westArea.setVisible(true);
        
        /*END OF WESTAREA*/
        
        /* START OF EASTAREA */
//        eastArea.setLayout(new FlowLayout(FlowLayout.CENTER));
        eastArea.setLayout(new GridLayout(3,1));
        eastArea.setBorder(BorderFactory.createLineBorder(Color.blue));
        eastArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
        eastArea.setBackground(new Color(28, 25, 26));
        eastArea.setPreferredSize(new Dimension(200,200));
        eastArea.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        eastArea.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
            
        });
        
        //Start of button characteristics
        replaceButton.setPreferredSize(new Dimension(80,52));
        replaceButton.setDisabledIcon(replace.getBlack());
        replaceButton.setEnabled(false);
        duplicateButton.setPreferredSize(new Dimension(80,52));
        duplicateButton.setDisabledIcon(duplicate.getBlack());
        duplicateButton.setEnabled(false);
        saveButton.setPreferredSize(new Dimension(80,52));
        saveButton.setDisabledIcon(save.getBlack());
        deleteButton.setPreferredSize(new Dimension(80,52));
        deleteButton.setDisabledIcon(delete.getBlack());
        deleteButton.setEnabled(false);
        insertButton.setPreferredSize(new Dimension(80,52));
        insertButton.setDisabledIcon(insert.getBlack());
        newButton.setPreferredSize(new Dimension(80,52));
        newButton.setDisabledIcon(neww.getBlack());
        openButton.setPreferredSize(new Dimension(80,52));
        openButton.setDisabledIcon(open.getBlack());
        reportButton.setPreferredSize(new Dimension(80,52));
        reportButton.setDisabledIcon(report.getBlack());
        exportButton.setPreferredSize(new Dimension(160,20));
        exportButton.setDisabledIcon(export.getBlack());
        exportButton.setEnabled(true);
        
        eastOne.setBackground(new Color(28, 25, 26));
        eastTwo.setBackground(new Color(28, 25, 26));
        eastThree.setBackground(new Color(28, 25, 26));
        eastThree.setLayout(new GridLayout(2,1));
        eastThreeOne.setBackground(new Color(28, 25, 26));
        eastThreeTwo.setBackground(new Color(28, 25, 26));
        
        //End of button characteristics
        
        SwingUtilities.invokeLater(() -> {
            tb.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
                if (tb.getSelectionModel().isSelectionEmpty() == true)
                {
                    replaceButton.setEnabled(false);
                    duplicateButton.setEnabled(false);
                    saveButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                }
                else                
                {
                    replaceButton.setEnabled(true);
                    duplicateButton.setEnabled(true);
                    saveButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                }
                
                
            });
        });
        
        saveButton.addActionListener((e) -> {
           if (!equipmentHashmap.isEmpty()) 
           {
               writer.saveFile(openedFile, equipmentHashmap);
           }
           else
                JOptionPane.showMessageDialog(null, "Table is empty!", "Empty Table!", JOptionPane.INFORMATION_MESSAGE);
        });
        
        duplicateButton.addActionListener((e)-> {
            if (!equipmentHashmap.isEmpty())
            {
                String s = (String) dtm.getValueAt(tb.convertRowIndexToModel(tb.getSelectedRow()), tb.convertColumnIndexToModel(0));
                Equipment eq = equipmentHashmap.get(s).duplication();
                eq.setId(String.valueOf(maxKey()));
                equipmentHashmap.put(eq.getId(), eq);
                dtm.addRow(eq.equipArray());
                rp.populateRoomEq(eq, MKT500, MKT310, MKT602);
                System.out.println(eq.toString());
            }
        });
        
        reportButton.addActionListener((e) ->{
            if (!equipmentHashmap.isEmpty())
                new reportGui(equipmentHashmap);
            else 
                JOptionPane.showMessageDialog(null, "No rows yet!", "No existing Row to Report!", JOptionPane.ERROR_MESSAGE);
        });
        
        exportButton.addActionListener((e) ->{
            if (!equipmentHashmap.isEmpty())
            {
                String fName = JOptionPane.showInputDialog("Enter Filename");
                
                if (writer.fileExists(fName))
                {
                    int approve = JOptionPane.showConfirmDialog(null, "Filename already exists! Overwrite?", "Existing Filename", JOptionPane.YES_NO_OPTION);
                    if (approve == JOptionPane.YES_OPTION)
                    {
                        writer.writeFile(fName, equipmentHashmap);
                    }
                }
                else
                        writer.writeFile(fName, equipmentHashmap);

            }
            else
                JOptionPane.showMessageDialog(null, "No rows to export!", "Empty Table!", JOptionPane.INFORMATION_MESSAGE);

        });
        
        openButton.addActionListener((e) -> {
            int choice = JOptionPane.showConfirmDialog(null, "Open a new .cvs file?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
            {
                fileChooser.setFileFilter(allowedFiles);
                fileChooser.setAcceptAllFileFilterUsed(false);
                int open = fileChooser.showOpenDialog(null);

                if (open == JFileChooser.APPROVE_OPTION)
                {
                    resetValues();
                    openedFile = fileChooser.getSelectedFile().getAbsolutePath();
                    System.out.println(openedFile);
                    reader = new CSVreader(openedFile);
                    equipmentHashmap = ef.createHashMapEquipFromFile(reader);
                    rp.populateRoomHashMap(equipmentHashmap, MKT500, MKT310, MKT602);
//                    dtm.setRowCount(0);
                    dtm.setDataVector(reader.getTrueRows(), normalColumnContent);
                    
                    if (!reader.getErrorRow().isEmpty())
                        new FailedGui(reader);
                }
            }
        });// end of openButton ActionListener
        
        newButton.addActionListener((e) -> {
            int choice = JOptionPane.showConfirmDialog(null, "Start a new table? Unsaved session will be lost.", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION)
            {
                resetValues();
            }
        });
        
        insertButton.addActionListener((e) -> {
            InsertGui ig = new InsertGui(this,equipmentHashmap);
            ig.setVisible(true);
            
            if (ig.newS != null)
            {
                dtm.addRow(ig.newS);
                equipmentHashmap.put(ig.newS[0], new EquipmentFactory().createEquipmentFromInsert(ig.newS));
                rp.populateRoomHashMap(equipmentHashmap, MKT500, MKT310, MKT602);
            }
        });
        
        replaceButton.addActionListener((e) -> {
            replaceButton.setIcon(replace.getOriginal());
            String[] selectedRowData = new String[6];
            for (int i = 0; i < tb.getColumnCount(); i++)
            {
                selectedRowData[i] = (String) dtm.getValueAt(tb.convertRowIndexToModel(tb.getSelectedRow()), tb.convertColumnIndexToModel(i));
            }
            equipmentHashmap.remove((String) dtm.getValueAt(tb.convertRowIndexToModel(tb.getSelectedRow()), tb.convertColumnIndexToModel(0)));
            dtm.removeRow(tb.convertRowIndexToModel(tb.getSelectedRow()));
            ReplaceGui rg = new ReplaceGui(this,equipmentHashmap, selectedRowData);
            rg.setVisible(true);
            
            if (rg.newS != null)
            {
                dtm.addRow(rg.newS);
                equipmentHashmap.put(rg.newS[0], new EquipmentFactory().createEquipmentFromInsert(rg.newS));
                replaceButton.setIcon(replace.getOriginal());
            }
            else
            {
                dtm.addRow(selectedRowData);
                equipmentHashmap.put(selectedRowData[0], new EquipmentFactory().createEquipmentFromInsert(selectedRowData));
                replaceButton.setIcon(replace.getOriginal());
            }
        });
        deleteButton.addActionListener((ActionEvent e) -> {
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to delete this row?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                String deleted = (String) dtm.getValueAt(tb.convertRowIndexToModel(tb.getSelectedRow()), tb.convertColumnIndexToModel(0));
                rp.depopulateRoomHashMap(equipmentHashmap.get(deleted), MKT500, MKT310, MKT602);
                equipmentHashmap.remove((String) dtm.getValueAt(tb.convertRowIndexToModel(tb.getSelectedRow()), tb.convertColumnIndexToModel(0)));
                dtm.removeRow(tb.convertRowIndexToModel(tb.getSelectedRow()));
                deleteButton.setIcon(delete.getOriginal());
                JOptionPane.showMessageDialog(null, "ID " + deleted + " has been deleted.");
            } else if (choice == JOptionPane.NO_OPTION) {
                deleteButton.setIcon(delete.getOriginal());
            }
        });
        
        /**
         * 
         * Start of Mouse Listeners
         * 
        */
        
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                {
                    deleteButton.setIcon(delete.getGlow());
                    updateLabel.setText("Deletes the selected row");
                }
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                {
                    deleteButton.setIcon(delete.getOriginal());
                    updateLabel.setText("");
                }
            }
        });
        insertButton.addMouseListener(new java.awt.event.MouseAdapter()
        {   
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                insertButton.setIcon(insert.getGlow());
                updateLabel.setText("Insert a new row");
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                insertButton.setIcon(insert.getOriginal());
                updateLabel.setText("");
            }
        });
        replaceButton.addMouseListener(new java.awt.event.MouseAdapter()
        {   
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                {
                    replaceButton.setIcon(replace.getGlow());
                    updateLabel.setText("Replace details of selected row");
                }
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                {
                    replaceButton.setIcon(replace.getOriginal());
                    updateLabel.setText("");
                }
                
            }
        });
        duplicateButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                {
                    duplicateButton.setIcon(duplicate.getGlow());
                    updateLabel.setText("Create selected row copies");
                }
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                if (tb.getSelectionModel().isSelectionEmpty() == false)
                    duplicateButton.setIcon(duplicate.getOriginal());
            }
        });
        saveButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {

                saveButton.setIcon(save.getGlow());
                updateLabel.setText("Save's current session table");
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {

                saveButton.setIcon(save.getOriginal());
                updateLabel.setText("");

            }
        });
        exportButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                    exportButton.setIcon(export.getGlow());
                    updateLabel.setText("Exports table rows as .csv file");
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                    exportButton.setIcon(export.getOriginal());
                    updateLabel.setText("");
            }
        });
        newButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                    newButton.setIcon(neww.getGlow());
                    updateLabel.setText("Creates a new table");
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                    newButton.setIcon(neww.getOriginal());
                    updateLabel.setText("");
            }
        });
        openButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                    openButton.setIcon(open.getGlow());
                    updateLabel.setText("Open a .csv file");
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                    openButton.setIcon(open.getOriginal());
                    updateLabel.setText("");
            }
        });
        reportButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                    reportButton.setIcon(report.getGlow());
                    updateLabel.setText("Generate report from table details");
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                    reportButton.setIcon(report.getOriginal());
                    updateLabel.setText("");
            }
        });
        
        /**
         * 
         * End of Button Listeners
         * 
         */
        
        updateLabel.setForeground(Color.white);
        
        eastOne.add(replaceButton);
        eastOne.add(duplicateButton);
        eastOne.add(saveButton);
        eastOne.add(deleteButton);

        eastTwo.add(insertButton);
        eastTwo.add(newButton);
        eastTwo.add(openButton);
        eastTwo.add(reportButton);

        eastThreeOne.add(exportButton);
        eastThreeTwo.add(updateLabel);
        eastThree.add(eastThreeOne);
        eastThree.add(eastThreeTwo);
        
        eastArea.add(eastOne);
        eastArea.add(eastTwo);
        eastArea.add(eastThree);
        
        eastArea.setVisible(true);
        
        /*END OF EASTAREA*/
        
        /*START OF EXTRAAREA*/
        extraArea.setLayout(new GridLayout(4, 1));
        extraArea.setBorder(BorderFactory.createLineBorder(Color.blue));
        extraArea.setBackground(new Color(28, 25, 26));
        extraArea.setPreferredSize(new Dimension(210, 200));
        extraArea.addMouseMotionListener(new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {
                
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                
            }
            
        });
        
        extraAreaLabel.setBackground(Color.GREEN);
        extraAreaLabel.setPreferredSize(new Dimension(50,50));
        labelFilters.setText("Filters");
        labelFilters.setBackground(Color.lightGray);
        labelFilters.setFont(new Font("Times New Roman", Font.BOLD,20));
        
        rowDisplay.setBackground(new Color(28, 25, 26));
        rowFilterTitle.setBackground(new Color(28, 25, 26));
        rowSearch.setBackground(new Color(28, 25, 26));
        rowFilt.setBackground(new Color(28, 25, 26));
        
        roomDropdown = new JComboBox<>(locations);
        equipmentDropdown = new JComboBox<>(equipments);
        columnDropdown = new JComboBox<>(colFilters);
        
        filtersForSearch.setBorder(new EmptyBorder(0, 50, 5, 50));
        filtersForSearch.setForeground(Color.white);
        filtersTypeEquip.setBorder(new EmptyBorder(0, 50, 5, 50));
        filtersTypeEquip.setForeground(Color.white);
        
        displayRoomButton.setFocusable(false);
        displayRoomButton.addActionListener((ActionEvent e) ->{
            if (!equipmentHashmap.isEmpty())
                new DisplayRoomGui(activeRooms[roomNumber]); 
            else
                JOptionPane.showMessageDialog(null, "No rows to display!", "Empty Table!", JOptionPane.INFORMATION_MESSAGE);
            
        });
        displayByRoom.setBorder(new EmptyBorder(0, 50, 5, 50));
        displayByRoom.setForeground(Color.white);
        
        
        r1.setText("500");
        r1.setFocusable(false);
        r1.addActionListener((ActionEvent e) -> {
            roomNumber = 0;
        });
        r2.setText("310");
        r2.setFocusable(false);
        r2.addActionListener((ActionEvent e) -> {
            roomNumber = 1;
        });
        r3.setText("602");
        r3.setFocusable(false);
        r3.addActionListener((ActionEvent e) -> {
            roomNumber = 2;
        });
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        
        
        Runnable updateRows = () -> {
            int selectedColumn = columnDropdown.getSelectedIndex();
            String searchText = searchField.getText().toLowerCase();
            String selectedRoom = String.valueOf(roomDropdown.getSelectedItem());
            String selectedEquipment = equipmentDropdown.getSelectedItem().toString();
            
            ArrayList<RowFilter<Object, Object>> filt = new ArrayList<>();
            if (selectedColumn == 0)
                filt.add(RowFilter.regexFilter("(?i)^" + searchText));
            else
                filt.add(RowFilter.regexFilter("(?i)^" + searchText, selectedColumn-1));
            //RowFilter<Object, Object> rf = RowFilter.regexFilter("(?i)^" + searchText); // filter by search text in Name column
            
            // Filter by location
            if (!"All".equals(selectedRoom))
                filt.add(RowFilter.regexFilter(String.valueOf(roomDropdown.getSelectedItem())));
            
            // Filter by equipment type
            if (!"All".equals(selectedEquipment))
                filt.add(RowFilter.regexFilter(String.valueOf(equipmentDropdown.getSelectedItem())));
            
            mainFilter = RowFilter.andFilter(filt);

            trs.setRowFilter(mainFilter); 
        };
        
        searchField.setPreferredSize(new Dimension(130,25));
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateRows.run();}
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateRows.run();}

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateRows.run();}

        });
        
        searchFieldLabel.setForeground(Color.white);
        
        roomDropdown.setPreferredSize(new Dimension(130,25));
        roomDropdown.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                updateRows.run();
            }
        });
        roomsFieldLabel.setForeground(Color.white);
        
        equipmentDropdown.setPreferredSize(new Dimension(130,25));
        equipmentDropdown.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                updateRows.run();
            }
        });
        equipmentsFieldLabel.setForeground(Color.white);
        columnDropdown.setPreferredSize(new Dimension(130,25));
        columnDropdown.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED)
                updateRows.run();
        });
        columnsFieldLabel.setForeground(Color.WHITE);
        
        
        rowSearch.add(filtersForSearch);
        rowSearch.add(columnsFieldLabel);
        rowSearch.add(columnDropdown);
        rowSearch.add(searchFieldLabel);
        rowSearch.add(searchField);
        rowFilt.add(filtersTypeEquip);
        rowFilt.add(roomsFieldLabel);
        rowFilt.add(roomDropdown);
        rowFilt.add(equipmentsFieldLabel);
        rowFilt.add(equipmentDropdown);
        rowDisplay.add(displayByRoom);
        rowDisplay.add(r1);
        rowDisplay.add(r2);
        rowDisplay.add(r3);
        rowDisplay.add(displayRoomButton);
        
        extraArea.add(rowSearch);
        extraArea.add(rowFilt);
        extraArea.add(rowDisplay);
        extraArea.setVisible(true);
        
        //majorPane.add(extraArea, BorderLayout.WEST);
        /*END OF EXTRAAREA*/
        
        /*START OF SOUTHAREA*/
        southArea.setBackground(new Color(64, 66, 163));
        southArea.setPreferredSize(new Dimension(100,100));
        southArea.setBorder(BorderFactory.createLineBorder(new Color(14, 26, 46), 5));
        southArea.setLayout(new GridLayout(2,1));
        
        southFirstHalf.setLayout(new FlowLayout(FlowLayout.LEFT));
        southSecondHalf.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        southFirstHalf.setBackground(new Color(64, 66, 163));
        southSecondHalf.setBackground(new Color(64, 66, 163));
        
        credits.setText("Coded by Al Jann P. Jakilan. Assistants: Lance De La Paz, Christian Danielle R. Leano, Dino T. Timbol, Kenneth Aliling.");
        credits.setForeground(Color.white);
        credits.setBorder(new EmptyBorder(20, 0, 0, 0));
        
        southSecondHalf.add(credits);
        
        southArea.add(southFirstHalf);
        southArea.add(southSecondHalf);
        
        
        /*END OF SOUTHAREA*/
        
        guiFrame.add(southArea, BorderLayout.SOUTH);   
        guiFrame.add(westArea, BorderLayout.CENTER);   
        guiFrame.add(extraArea, BorderLayout.WEST);
        guiFrame.add(eastArea, BorderLayout.EAST);
           
        /*END OF SOUTHAREA*/
        
        guiFrame.setLocationRelativeTo(null);
        guiFrame.setVisible(true);  //set the main frame to visible
        
    }
    
    public void resetValues()
    {
        dtm.setRowCount(0);
        equipmentHashmap.clear();
        rp.clearRoomHashMap(MKT500, MKT310, MKT602);
    }
    public int maxKey()
    {
        return Integer.parseInt(Collections.max(equipmentHashmap.entrySet(), Map.Entry.comparingByKey()).getKey())+1;
    }
    public void printing(String str) {
        for (int i = 0; i < tb.getRowCount(); i++) {
            for (int j = 0; j < tb.getColumnCount(); j++) {
                String faker = (String) dtm.getValueAt(tb.convertRowIndexToModel(i), tb.convertColumnIndexToModel(j)); //jack
                System.out.println(faker);
            }
        }
    }
    
//    public String[] selectedRowDataToArray()
//    {
//        String[] s = new String[tb.getColumnCount()];
//        String ss = "";
//        for (int i = 0; i < tb.getRowCount(); i++)
//            for (int j = 0; j < tb.getColumnCount(); j++)
//            {
//                ss = (String) dtm.getValueAt(tb.convertRowIndexToModel(tb.getSelectedRow()),tb.convertColumnIndexToModel(tb.getSelectedColumn()));
//                
//            }
//    }
}
