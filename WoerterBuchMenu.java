/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dictionary;

/**
 *
 * @author Nataniel
 * @author Mark
 * @version 18.11.2015
 */

import com.sun.glass.events.KeyEvent;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.TreeMap;


public class WoerterBuchMenu extends JMenuBar implements ActionListener {

    WoerterBuch wBook;
    WoerterBuchGUI wbg;
    
    Container container;
    JFileChooser fc = new JFileChooser();
    JMenuItem mA, mB, mC;             //mA usw. sind die Inhalte für den ersten Menu.
    JMenuItem oA, oC, oD, oBa, oBb;   //oA usw. sind die Options für den zweiten Menu.
                                          
    JMenu menuA, menuB, oB;
    JMenuBar mainMenuBar;
    JPanel PanelLbStatus;
    JLabel stsDict; //it makes a problem, because jlabel cant be updated
    
    JPanel stPerformance;
    JLabel stsPerformance;
    
    public WoerterBuchMenu(WoerterBuch wb){
        
        wBook = wb;
        mainMenuBar = new JMenuBar();
        
        mainMenuBar.setOpaque(true);
        mainMenuBar.setPreferredSize(new Dimension(200,20));
        
        //der erste MenuBar
        menuA = new JMenu("File");
        menuA.setMnemonic(KeyEvent.VK_A);
        mainMenuBar.add(menuA);
        
        //inhalte von dem ersten MenuBar, entspricht File-Menu
        mA = new JMenuItem("Open");
        mA.setMnemonic(KeyEvent.VK_T);
        mA.addActionListener(this);
        menuA.add(mA);
        
        mB = new JMenuItem("Save");
        mB.setMnemonic(KeyEvent.VK_T);
        mB.addActionListener(this);
        menuA.add(mB);
        
        //Separator
        menuA.addSeparator();
        
        menuB = new JMenu("DictiOption");
        menuB.setMnemonic(KeyEvent.VK_B);
        menuA.add(menuB);
        
        //Separator
        menuA.addSeparator();
        
        mC = new JMenuItem("Exit");
        mC.setMnemonic(KeyEvent.VK_T);
        mC.addActionListener(this);
        menuA.add(mC);
        
        //Inhalte von dem zweiten MenuBar, entspricht DictiOption
        oB = new JMenu("MapDictionary");
        oB.setMnemonic(KeyEvent.VK_B);
        oB.addActionListener(this);
        menuB.add(oB);
       
        //unter dem Menu MapDictionary
        oBa = new JMenuItem("HashMapDictionary");
        oBa.setMnemonic(KeyEvent.VK_T);
        oBa.addActionListener(this);
        oB.add(oBa);
        
        //unter dem Menu MapDictionary
        oBb = new JMenuItem("TreeMapDictionary");
        oBb.setMnemonic(KeyEvent.VK_T);
        oBb.addActionListener(this);
        oB.add(oBb);
        
        oC = new JMenuItem("SortedArrayDictionary");
        oC.setMnemonic(KeyEvent.VK_T);
        oC.addActionListener(this);
        menuB.add(oC);
        
        //das zusätzliche Panel für JLabel bzw. Status der Dictionary
        PanelLbStatus = new JPanel();
        PanelLbStatus.setLayout(new GridLayout(1,1));
        
        //Border für status
        PanelLbStatus.setLayout(new BoxLayout(PanelLbStatus, BoxLayout.LINE_AXIS));
        
        stsDict = new JLabel("Hallo this is Dictionary");
        PanelLbStatus.add(stsDict);
        
        stPerformance = new JPanel();
        stPerformance.setLayout(new GridLayout(1,1));
        
        this.add(menuA);
        this.add(Box.createHorizontalGlue()); 
        this.add(PanelLbStatus);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setSelectedFile(new File(System.getProperty("user.dir")));
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object source = e.getSource();
       Component myF = null;

       
       //open-option
       if(source==mA){
           fc.showOpenDialog(this);
           if(fc.getSelectedFile() != null){
               wBook.read(fc.getSelectedFile());
           }
       }
       
       //save-option
       if(source==mB){
           fc.showSaveDialog(this);
           if(fc.getSelectedFile() != null){
               wBook.save(fc.getSelectedFile());
           }
       }
        
       //exit-option
       if(source == mC){
           	int n = JOptionPane.showConfirmDialog(myF, "Would you like to end this app?"
    							, "Please enter!"
    							, JOptionPane.YES_NO_OPTION);
    		if(n == JOptionPane.YES_OPTION){
    			System.exit(0);	
    			} else if(n == JOptionPane.NO_OPTION){
    			return;
    			} else {
    			JOptionPane.showMessageDialog(myF, "The answer isn't acceptable");
    		}
       }

       //HashMap option
       if(source==oBa){
           stsDict.setText("HashMapDictionary");
          JOptionPane.showMessageDialog(myF, "HashMapDictionary is selected");
         WoerterBuchGUI.dt = new mapDictionary(new HashMap());
       }
       
       //TreeMap option
       if(source==oBb){
          JOptionPane.showMessageDialog(myF, "TreeMapDictionary is selected");
          stsDict.setText("TreeMapDictionary");
         WoerterBuchGUI.dt = new mapDictionary(new TreeMap());
       }
       
     
        if(source == oC){
           JOptionPane.showMessageDialog(myF, "ArrayDictionary is selected");
           stsDict.setText("ArrayDictionary");
           WoerterBuchGUI.dt = new sortedArrayDictionary();
       }

     }
    
}
