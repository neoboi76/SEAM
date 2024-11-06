/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SEAM.main;
import com.SEAM.GUI.MainGui;
import com.SEAM.GUI.loginGUI;

/**
 *
 * @author ALJANN
 */
public class mainClass  {
    public static void main(String[] args)
    {

        int checking;
        loginGUI login = new loginGUI();
        
        
        /*
        the while loop you see below has a thread.sleep to dampen cpu usage
        from being a loop. if no thread.sleep no 100 grade.
        */
        
        while(true)
        {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (login.getTries() == 0)
                System.exit(0);
            else if (login.isCorrect() == true)
            {
                    login.getFrame().dispose();
                    break;
            }
        }
        
        //this is the main GUI/JFrame and the bulk of the program
        //technically we can call the constructor instead of assigning it
        new MainGui();

            
    }
}
