// import java.util.HashMap;
// import javax.swing.*;

// import java.awt.Color;
// import java.awt.Component;
// import java.awt.Container;
// import java.awt.Dimension;
// import java.awt.Graphics;
// import java.awt.GridBagConstraints;
// import java.awt.GridBagLayout;
// import java.awt.Image;
// import java.awt.Insets;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.File;
// import java.io.FilenameFilter;
// import java.util.ArrayList;

// import javax.swing.BorderFactory;
// import javax.swing.ImageIcon;
// import javax.swing.JComponent;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTextPane;
// import javax.swing.JOptionPane;
// import javax.swing.Timer;
// import javax.swing.border.Border;

// import java.lang.Math;
// import java.awt.Container;

public class NPC {

    NPCFace face;
    public Fish playerFish;
    public String[] inventory;

    private String[] menu = {
        "Cast Line",
        "View Fish",
        "View Items"
    };


    public NPC(){
        face = new NPCFace();

        face.popMessage("The Deep is calling.", "The Boatman");
    }

    public void mainMenu(){
        String s = face.popOption("What would you like to do?","The Boatman",menu);
        if (s.equals(menu[0])){
            new Battle(playerFish.getLevel(),this);
        }else if (s.equals(menu[1])){
            face.createImagePanel();
            face.setImage(playerFish.getType());
            face.popMessage(

                "\nLevel: " + playerFish.getLevel() +
                "\nHealth: " + playerFish.getScaledHealth() + " (" + playerFish.getHealth() + " + " + (playerFish.getScaledHealth() - playerFish.getHealth()) + ")" +
                "\nAttack: " + playerFish.getScaledAttack() + " (" + playerFish.getAttack() + " + " + (playerFish.getScaledAttack() - playerFish.getAttack()) + ")" +
                "\nSpeed: " + playerFish.getScaledSpeed() + " (" + playerFish.getSpeed() + " + " + (playerFish.getScaledSpeed() - playerFish.getSpeed()) + ")"
                
                ,playerFish.getName()
            );
            face.resetImagePanels();
        }else if(s.equals(menu[2])){
            //********************************************************************************************************************** CONTINUE HERE! MAKE INVENTORY/ITEMS VARIABLES AND METHODS**********************************************************************************************************************
        }
        mainMenu();  
    }

    public Fish getFish(){
        return playerFish;
    }

    public void changeFish(Fish fish){
        playerFish = fish;
    }
}
