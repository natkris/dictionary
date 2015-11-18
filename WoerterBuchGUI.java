/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dictionary;

/**
 * @author Nataniel
 * @version 18.11.2015
 */

import javax.swing.*;

public class WoerterBuchGUI extends JFrame {
    
    public static WoerterBuch wBook;
    public static dictionary dt;
    WoerterBuchMenu wbm;
    
    public WoerterBuchGUI(){
        
        wBook = new WoerterBuch();
        
        this.setJMenuBar(new WoerterBuchMenu(wBook));
        
        //MainPanel
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(new WoerterBuchInsert(wBook));
        mainPanel.add(new WoerterBuchSearchDelete(wBook));
    
        this.setContentPane(mainPanel);
    
        this.setTitle("Dictionary German - English");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
     
    public static void main(String[] args){
          new WoerterBuchIntro();
    }
    
}
