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
	private JPanel graphPanel;
 
  public Vue() { 
	  
	  	Controleur controleur = new Controleur(this);
	  
	  	// instantiation des attributs de la classe
	  	this.champsParametres = new HashMap<>();
	  
	  	// creation de 3 panels et ajout du layout a la classe
	    this.setLayout(new BorderLayout());
	  	JPanel parametres = new JPanel(); // contient les parametres � entrer par l'utilisateur
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
  		this.valider.addActionListener(controleur);
  		parametres.add(this.valider);

	    
  		JFreeChart graph = ChartFactory.createScatterPlot(
  		        "Nuage de points", 
  		        "Xn", "Xn+1", null);
	    
	    ChartPanel chartPanel = new ChartPanel(graph);
	    
	    this.graphPanel = new JPanel();
	    this.graphPanel.add(chartPanel);
	    this.add(graphPanel);
  } 
  
  public void afficherDonnee(XYSeries donnee) {
	  	this.graphPanel.removeAll();
	  	this.graphPanel.revalidate();
	  	
		XYSeriesCollection data = new XYSeriesCollection();
		data.addSeries(donnee);
		
		JFreeChart graph = ChartFactory.createScatterPlot(
	        "Nuage de points", 
	        "Xn", "Xn+1", data);
	  
	    
	    //Changes background color
	    XYPlot plot = (XYPlot)graph.getPlot();
	    plot.setBackgroundPaint(new Color(255,228,196));
	    
	    ChartPanel chartPanel = new ChartPanel(graph);
	    this.graphPanel.add(chartPanel);

		this.graphPanel.repaint();
  }

  public Map<String, JTextField> getParametres() {
	  return this.champsParametres;
  }
  
  
}