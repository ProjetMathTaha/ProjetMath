package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection; 
 
public class Vue extends JPanel { 
	
	private Map<String, JTextField> champsParametres; // contient les JTextField des parametres
	private JButton valider;
 
  public Vue() { 
	  
	  	// instantiation des attributs de la classe
	  	this.champsParametres = new HashMap<>();
	  
	  	// creation de 3 panels et ajout du layout a la classe
	    this.setLayout(new BorderLayout());
	  	JPanel parametres = new JPanel(); // contient les parametres à entrer par l'utilisateur
	  	JPanel graphs = new JPanel(); // contient les graphs
	  	JPanel stats = new JPanel(); // contient les stats
	  	
	  	this.add(parametres, BorderLayout.NORTH);
	  	this.add(graphs, BorderLayout.CENTER);
	  	this.add(stats, BorderLayout.SOUTH);
	  	
	  	// panel des parametres
	  	parametres.setLayout(new GridLayout(2, 1));
	  		// panel qui contient les textfield pour entrer les valeurs
	  		JPanel parametresValeurs = new JPanel();
	  		parametres.add(parametresValeurs);
	  		parametresValeurs.setLayout(new GridLayout(1, 10));
	  		
	  		JLabel jlabelA = new JLabel("a :");
	  		jlabelA.setHorizontalAlignment(SwingConstants.CENTER);
	  		parametresValeurs.add(jlabelA);
	  		champsParametres.put("a", new JTextField());
	  		parametresValeurs.add(champsParametres.get("a"));
	  		
	  		JLabel jlabelB = new JLabel("b :");
	  		jlabelB.setHorizontalAlignment(SwingConstants.CENTER);
	  		parametresValeurs.add(jlabelB);
	  		champsParametres.put("b", new JTextField());
	  		parametresValeurs.add(champsParametres.get("b"));
	  		
	  		JLabel jlabelX0 = new JLabel("x0 :");
	  		jlabelX0.setHorizontalAlignment(SwingConstants.CENTER);
	  		parametresValeurs.add(jlabelX0);
	  		champsParametres.put("x0", new JTextField());
	  		parametresValeurs.add(champsParametres.get("x0"));
	  		
	  		JLabel jlabelM = new JLabel("m :");
	  		jlabelM.setHorizontalAlignment(SwingConstants.CENTER);
	  		parametresValeurs.add(jlabelM);
	  		champsParametres.put("m", new JTextField());
	  		parametresValeurs.add(champsParametres.get("m"));
	  		
	  		JLabel jlabelNB = new JLabel("nb :");
	  		jlabelNB.setHorizontalAlignment(SwingConstants.CENTER);
	  		parametresValeurs.add(jlabelNB);
	  		champsParametres.put("nb", new JTextField());
	  		parametresValeurs.add(champsParametres.get("nb"));
	  		
	  		
	  		
	  		// le bouton valider
	  		this.valider = new JButton("valider");
	  		parametres.add(this.valider);
	
	    
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