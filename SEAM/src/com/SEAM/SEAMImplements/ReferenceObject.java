/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SEAM.SEAMImplements;

/**
 *
 * @author ALJANN
 */
public abstract class ReferenceObject {
    
    private static String[] standardCol = {"ID","Name","Type","Condition","Location","Quantity"};
    
    private static String[] eqList = {"Printer","Projector","Speakers","Smartboard","Tablet"};
    
    private static String[] condiList = {"Excellent","Great","Good","Decent","Poor","Needs Replacement","Missing","Disposed"};
    
    private static String[] roomList = {"MKT500","MKT310","MKT602"};
    
    private static String[] eqListDD = {"","Printer", "Projector", "Speakers", "Smartboard", "Tablet"};

    private static String[] condiListDD = {"","Excellent", "Great", "Good", "Decent", "Poor", "Needs Replacement", "Missing", "Disposed"};

    private static String[] roomListDD = {"","MKT500", "MKT310", "MKT602"};

    public static String[] getStandardCol() {
        return standardCol;
    }

    public static String[] getEqList() {
        return eqList;
    }

    public static String[] getCondiList() {
        return condiList;
    }

    public static String[] getRoomList() {
        return roomList;
    }

    public static String[] getEqListDD() {
        return eqListDD;
    }

    public static String[] getCondiListDD() {
        return condiListDD;
    }

    public static String[] getRoomListDD() {
        return roomListDD;
    }
    
    
}
