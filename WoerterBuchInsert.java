/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dictionary;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Nataniel
 */
public class WoerterBuchInsert extends JPanel implements ActionListener {

    
    WoerterBuch wBook;
    WoerterBuchMenu wbm;
    JTextField tGerman, tEnglish;
    JButton bInsert;
    Component myFrame = null;
    
    public WoerterBuchInsert(WoerterBuch wb){
        
        wbm = new WoerterBuchMenu(wBook);
        
        //der erste Panel, erste Spalte entspricht input panel
        JPanel panelInputA = new JPanel();
        panelInputA.setLayout(new GridLayout(2, 1));
        panelInputA.add(new JLabel("German"));
        panelInputA.add(new JLabel("English"));
        
        //der erste Panel, zweite Spalte entspricht input panel
        JPanel panelInputB = new JPanel();
        panelInputB.setLayout(new GridLayout(2, 1));
        tGerman = new JTextField("", 20);
        tEnglish = new JTextField("", 20);
        panelInputB.add(tGerman);panelInputB.add(tEnglish);
        
        //enter button im ersten Panel
        bInsert = new JButton("Insert");
        bInsert.addActionListener(this);
        
        //border input
        Border brA = BorderFactory.createTitledBorder("Input");
        this.setBorder(brA);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.add(panelInputA);this.add(panelInputB);this.add(bInsert);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        
        String deutsch = tGerman.getText();
        String englisch = tEnglish.getText();
        
        //insert option
        if(s==bInsert){
                WoerterBuchGUI.dt.insert(deutsch, englisch);
                JOptionPane.showMessageDialog(myFrame, "You have inserted one word");
            } 

        }

    
    
}
