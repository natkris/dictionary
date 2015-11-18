/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dictionary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 *
 * @author Nataniel
 * @version 18.11.2015
 */
public class WoerterBuchIntro extends JFrame implements ActionListener{
    
    JPanel mainPanel;
    JLabel titleLabel,aLabel,bLabel,cLabel,dLabel;
    JButton okButton;
    
    public WoerterBuchIntro(){
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
        titleLabel = new JLabel("Welcome to Dictionary");
        aLabel = new JLabel("1. Please chosse your implementation under File -> Dictionary");
        bLabel = new JLabel("2. Then chosse your data under File -> Open");
        cLabel = new JLabel("3. Through File -> Save you can save the data");
        dLabel = new JLabel("4. You can use another implementation through 'Reset Dictionary' ");
        
        okButton = new JButton("Ok");
        okButton.addActionListener(this);
        
        mainPanel.add(titleLabel);mainPanel.add(aLabel);mainPanel.add(bLabel);mainPanel.add(cLabel);
        mainPanel.add(dLabel);
        mainPanel.add(okButton);
        
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
    }    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        
        if(o == okButton)
            this.setVisible(false);
            new WoerterBuchGUI();
    }
}
