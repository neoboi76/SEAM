/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jakilan.myapps;
import GUI.*;
import SQL.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALJANN
 */
public class mainClass  {
    public static void main(String[] args)
    {
        /*
        code to connect the database to our java program
        since we use an offline database, our job is ez
        */
        
//        Connect conn = new Connect();
//        conn.connect();
        
        /* 
        when main program starts, login jframe is instantiated first:
        new login(*int var = chances, string cor = correct pass*)
        login jframe returns bool true if success, false if chances run out
        if login false=fail, close app, else proceed to main
         */
//        loginSecondGUI login = new loginSecondGUI();

//        int checking;
//        loginGUI login = new loginGUI();
        
        
        /*
        the while loop you see below has a thread.sleep to dampen cpu usage
        from being a loop. if no thread.sleep no 100 grade.
        */
        
//        while(true)
//        {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(mainClass.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (login.getTries() == 0)
//                System.exit(0);
//            else if (login.isCorrect() == true)
//            {
//                    login.getFrame().dispose();
//                    break;
//            }
//        }
        
        //this is the main GUI/JFrame and the bulk of the program
        //technically we can call the constructor instead of assigning it
        
        //new mainGUI();
        //new mainFrame();
        new MainGui();
        
        
//        String f = "src\\sample.csv";
//        String line = "";
//        String[] samp = null;
//        ArrayList<String[]> ls = new ArrayList<>();
//        
//        
//        int counterCol = 0;
//        int counterRow = 0;
//        char red = 0;
//        
//        
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(f));
//            while((line = br.readLine()) != null)
//            {
//                ls.add(line.split(","));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        for (String[] s:ls)
//        {
//            System.out.println(Arrays.toString(s));
//        }
            
    }
}
