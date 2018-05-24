package UI;

import java.awt.Color;
import java.awt.Component; 
import java.awt.FlowLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection; 
 
public class Vue extends JPanel { 
 
  public Vue() { 
	  
	  
	  	Controleur controleur = new Controleur(this);
	    
	  	JPanel don = new JPanel(); 
	    this.add(don); 
	    
	    don.setLayout(new GridLayout(2,1));
	    JPanel donHaut = new JPanel();
	    donHaut.setLayout(new GridLayout(1,4)); 
	     
	    donHaut.add(new JLabel("A :")); 
	    JTextField donA = new JTextField(); 
	    //donA.setPreferredSize( new Dimension( 50, 0 ) );

	    donHaut.add(donA); 
	    donHaut.add(new JLabel("B :")); 
	    JTextField donB = new JTextField(); 
	    donHaut.add(donB); 
	    donHaut.add(new JLabel("x0 :")); 
	    JTextField donX = new JTextField(); 

	    donHaut.add(donX); 
	    donHaut.add(new JLabel("m :"));
	    JTextField donM = new JTextField(); 
	    donHaut.add(donM);
	    JButton valider = new JButton("valider");
	    donHaut.add(valider);
	    valider.addActionListener( controleur);
	    
	    
	    don.add(donHaut);
	    
	    JLabel donBas = new JLabel();
	     don.add(donBas);
	    
	    
	    don.add(donX); 
	 
	    this.add(don); 
	
	
	    
	    // Create dataset
	    XYDataset dataset = createDataset();
	
	    // Create chart
	    JFreeChart chart = ChartFactory.createScatterPlot(
	        "Nuage de points", 
	        "Xn", "Xn+1", dataset);
	
	  //Changes background color
	    XYPlot plot = (XYPlot)chart.getPlot();
	    plot.setBackgroundPaint(new Color(255,228,196));
	    
	    ChartPanel panel = new ChartPanel(chart);
	    this.add(panel);
  } 

  private XYDataset createDataset() {
	    XYSeriesCollection dataset = new XYSeriesCollection();

	    //Boys (Age,weight) series
	    XYSeries series1 = new XYSeries("X0");
	    series1.add(1, 72.9);
	    series1.add(2, 81.6);
	    series1.add(3, 88.9);
	    series1.add(4, 96);
	    series1.add(5, 102.1);
	    series1.add(6, 108.5);
	    series1.add(7, 113.9);
	    series1.add(8, 119.3);
	    series1.add(9, 123.8);
	    series1.add(10, 124.4);

	    dataset.addSeries(series1);
	    
	  


	    return dataset;
	  }

  
  
}