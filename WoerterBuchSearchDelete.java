/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

/**
 *
 * @author Nataniel
 * @author Mark
 * @version 18.11.2015
 */
public class WoerterBuchSearchDelete extends JPanel implements ActionListener {
    
    WoerterBuch wBook;
    JTextField tGermanOut;
    JButton bEnter, bReset;
    JRadioButton sc, dl;
    public static JTextArea tOut;
    WoerterBuchMenu mn;
    public static JLabel stsEntry;
    Component myFrame = null;
    
    public WoerterBuchSearchDelete(WoerterBuch wB){
        wBook = wB;
        
        //der zweite Panel, entspricht search-delete Panel
        JPanel mainPanelSD = new JPanel();
        
        JPanel panelSDa = new JPanel();
        panelSDa.setLayout(new GridLayout(1, 1));
        panelSDa.add(new JLabel("German"));
        
        JPanel panelSDb = new JPanel();
        panelSDb.setLayout(new GridLayout(1,1));
        tGermanOut = new JTextField("", 20);
        panelSDb.add(tGermanOut);
        
        mainPanelSD.add(panelSDa);mainPanelSD.add(panelSDb);
        
        //border search-delete
        Border brB = BorderFactory.createTitledBorder("Search/Delete");
        mainPanelSD.setBorder(brB);
        mainPanelSD.setLayout(new BoxLayout(mainPanelSD, BoxLayout.LINE_AXIS));
        mainPanelSD.add(panelSDa);mainPanelSD.add(panelSDb);
        
        //RadioButton Search und Delete
        sc = new JRadioButton("Search");
        sc.setSelected(true);
        dl = new JRadioButton("Delete");
        ButtonGroup gr = new ButtonGroup();
        gr.add(sc);gr.add(dl);
        
        //Enter-Knopf
        bEnter = new JButton("Enter");
        bEnter.addActionListener(this);
        
        //Zusammenbinden
        mainPanelSD.add(sc);mainPanelSD.add(dl);mainPanelSD.add(bEnter);
        
        //Panel Output
        JPanel mainPanelOT = new JPanel();
        tOut = new JTextArea(20, 1);
        Border brC = BorderFactory.createTitledBorder("Output");
        mainPanelOT.setBorder(brC);
        mainPanelOT.setLayout(new BorderLayout());
        mainPanelOT.add(BorderLayout.CENTER, new JScrollPane(tOut));

        JPanel statusEntry = new JPanel();
        stsEntry = new JLabel("Total entr(y/ies): n words");
        statusEntry.add(stsEntry);
        
        bReset = new JButton("Reset Dictionary");
        bReset.addActionListener(this);
        JPanel clear = new JPanel();
        clear.add(bReset);
        
        //die Aussicht des Dictionarys
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(mainPanelSD);
        this.add(mainPanelOT);
        this.add(statusEntry);
        this.add(clear);
        
       
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Object s = e.getSource();
        
        String deutsch = tGermanOut.getText();
        String englischA,englischB;
        
        tOut.setText("");
        
        if(s == bEnter) {
            /*funktion für select*/
            if(sc.isSelected()){
                    try{
                        englischA = (String) WoerterBuchGUI.dt.search(deutsch);
                        tOut.setText(""+englischA.toString());
                    } catch (NullPointerException f){
                        JOptionPane.showMessageDialog(myFrame, "There is nothing to search!!");
                    }
                
                      
            } else if (dl.isSelected()){
            /*funktion für delete*/
                      try{
                        englischB = (String) WoerterBuchGUI.dt.remove(deutsch);
                        JOptionPane.showMessageDialog(myFrame, deutsch + " has been succesfully deleted");
                    } catch (NullPointerException f){
                        JOptionPane.showMessageDialog(myFrame, "There is nothing to delete!!");
                    }  
            }
        }
        
        if(s == bReset){
                WoerterBuchGUI wbg = new WoerterBuchGUI();
                JOptionPane.showMessageDialog(myFrame, "Now you can chosse another implementation!!");
        }
    }
    
}
