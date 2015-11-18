/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dictionary;

import java.awt.Component;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Nataniel
 */
public class WoerterBuch {
    
    //22.10.2015 ich denke diese wBook kann gelöscht werden.
     Component myFrame = null;
     public static double startTime = 0;
     public static int data[]; 
     int size, summeEntry ;
     String[] deutsch = new String[16000];
     String[] englisch = new String[16000];
     
     private void ensureCapacity(String o[],int newCapacity){
	if(newCapacity < size) {
		return;
	}
	String [] a = o;
	data = new int[newCapacity];
	System.arraycopy(a, 0, data, 0, size);
     }   
     
    //open file
    public void read(File f) {
        LineNumberReader in = null;
        try {
            in = new LineNumberReader(new FileReader(f));
            String line;
            int i = 0;
            while ((line = in.readLine()) != null) {
                String[] sf = line.split(" ");
                if (sf.length == 2) {
                    if(size >= deutsch.length){
                        ensureCapacity(deutsch, size*2);
                        ensureCapacity(englisch, size*2);
                    }
                    WoerterBuchGUI.dt.insert(sf[0], sf[1]);
                    deutsch[i] = sf[0];
                    englisch[i] = sf[1];
                    size++;
                    i++;
                } else if (sf.length == 3) {
                    WoerterBuchGUI.dt.insert(sf[0], sf[1] + sf[2]);
                } 
            }
            //to show your entries in output
            WoerterBuchSearchDelete.tOut.setText(WoerterBuchGUI.dt.toString());
            
            //to show how many entries you have from your dictionary
            WoerterBuchSearchDelete.stsEntry.setText("Total entr(y/ies): " + size + " words");
            
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(WoerterBuch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(File f) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(f);
            out.println(WoerterBuchGUI.dt.toString());
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(WoerterBuch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void showTime(int[] a){
        double endTime = System.nanoTime();
        
        double estimatedTime = endTime - startTime;
        
        System.out.println("Time since start: "+estimatedTime);
    }
}
