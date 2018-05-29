package UI;
import java.awt.GridLayout; 
 
import javax.swing.JFrame; 
import javax.swing.UIManager; 
import javax.swing.WindowConstants; 
 
public class Application { 
 
  public static void main(String[] args) throws Exception { 
     
    try { 
        UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() ); 
     } catch (Exception e) { 
                e.printStackTrace(); 
     } 
     
     
    JFrame fenetre  = new JFrame(); 
    fenetre.setLayout(new GridLayout(1, 1)); 
    fenetre.add(new Vue()); 
 
    fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
    fenetre.pack(); 
    fenetre.setVisible(true);     
  } 
} 