package UI;

import java.awt.Component; 
import java.awt.FlowLayout; 
import java.awt.GridLayout; 
 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
 
public class Vue extends JPanel { 
 
  public Vue() { 
    JPanel don = new JPanel(); 
    don.setLayout(new GridLayout(3,1)); 
     
    don.add(new JLabel("A :")); 
    JTextField donA = new JTextField(); 
    don.add(donA); 
    don.add(new JLabel("B :")); 
    JTextField donB = new JTextField(); 
    don.add(donB); 
    don.add(new JLabel("X :")); 
    JTextField donX = new JTextField(); 
    don.add(donX); 
 
    this.add(don); 
  } 
} 