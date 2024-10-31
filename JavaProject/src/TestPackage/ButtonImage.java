/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestPackage;

import javax.swing.ImageIcon;

/**
 *
 * @author ALJANN
 */
public class ButtonImage {
    ImageIcon original;
    ImageIcon glow;
    ImageIcon black;
    
    public ButtonImage(String original, String glow, String black)
    {
        this.original = new ImageIcon(original);
        this.glow = new ImageIcon(glow);
        this.black = new ImageIcon(black);
    }

    public ImageIcon getOriginal() {
        return original;
    }

    public ImageIcon getGlow() {
        return glow;
    }

    public ImageIcon getBlack() {
        return black;
    }
    
    
}
