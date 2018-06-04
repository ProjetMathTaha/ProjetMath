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
  	private JPanel parametres ;// contient les parametres ï¿½ entrer par l'utilisateur
  	private JPanel graphs; // contient les graphs
  	private JPanel stats ; // contient les stats
 
  public Vue() { 
	  
	  	Controleur controleur = new Controleur(this);
	  
	  	// instantiation des attributs de la classe
	  	this.champsParametres = new HashMap<>();
	  
	  	// creation de 3 panels et ajout du layout a la classe
	    this.setLayout(new BorderLayout());
	  	this.parametres = new JPanel(); // contient les parametres ï¿½ entrer par l'utilisateur
	  	this.graphs = new JPanel(); // contient les graphs
	  	this.stats = new JPanel(); // contient les stats
	  	
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
  		champsParametres.put("a", new JTextField("314125421"));
  		parametresValeurs.add(champsParametres.get("a"));
  		
  		JLabel jlabelB = new JLabel("b :");
  		jlabelB.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeurs.add(jlabelB);
  		champsParametres.put("b", new JTextField("1"));
  		parametresValeurs.add(champsParametres.get("b"));
  		
  		JLabel jlabelX0 = new JLabel("x0 :");
  		jlabelX0.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeurs.add(jlabelX0);
  		champsParametres.put("x0", new JTextField("4327"));
  		parametresValeurs.add(champsParametres.get("x0"));
  		
  		JLabel jlabelM = new JLabel("m :");
  		jlabelM.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeurs.add(jlabelM);
  		champsParametres.put("m", new JTextField("2675591"));
  		parametresValeurs.add(champsParametres.get("m"));
  		
  		JLabel jlabelNB = new JLabel("nb :");
  		jlabelNB.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeurs.add(jlabelNB);
  		champsParametres.put("nb", new JTextField("20001"));
  		parametresValeurs.add(champsParametres.get("nb"));
  		
  		
  		// le bouton valider
  		this.valider = new JButton("valider");
  		this.valider.addActionListener(controleur);
  		parametres.add(this.valider);

	    
  		JFreeChart graph = ChartFactory.createScatterPlot(
  		        "Nuage de points", 
  		        "Xn", "Xn+1", null);
	    
	    ChartPanel chartPanel = new ChartPanel(graph);
	    
	    this.graphs = new JPanel();
	    this.graphs.add(chartPanel);
	    this.add(graphs);
	    
	    
  }
  
  public void afficherDonnee(XYSeries donnee) {
	  	this.graphs.removeAll();
	  	this.graphs.revalidate();
	  	
		XYSeriesCollection data = new XYSeriesCollection();
		data.addSeries(donnee);
		
		JFreeChart graph = ChartFactory.createScatterPlot(
	        "Nuage de points", 
	        "Xn", "Xn+1", data);
	  
	    
	    //Changes background color
	    XYPlot plot = (XYPlot)graph.getPlot();
	    plot.setBackgroundPaint(new Color(255,228,196));
	    
	    ChartPanel chartPanel = new ChartPanel(graph);
	    this.graphs.add(chartPanel);

		this.graphs.repaint();
  }
  
  public void afficherStats( float frequenceZero , float[]frequenceDoublets, float difference, int periode) {
	  this.stats.removeAll();
	  this.stats.revalidate();
	  this.stats.setLayout(new GridLayout(frequenceDoublets.length +2, 1 ));
	  this.stats.add(new JLabel("frequence de zero dans la suite= "+frequenceZero));
	  this.stats.add(new JLabel("frequence de 00 = "+frequenceDoublets[0]));
	  this.stats.add(new JLabel("frequence de 01 = "+frequenceDoublets[1]));
	  this.stats.add(new JLabel("frequence de 10 = "+frequenceDoublets[2]));
	  this.stats.add(new JLabel("frequence de 11 = "+frequenceDoublets[3]));
	  this.stats.add(new JLabel("TOTAL 4 FREQUENCES = "+(frequenceDoublets[0]+frequenceDoublets[1]+frequenceDoublets[2]+frequenceDoublets[3])));
	  
	  this.stats.add(new JLabel("Différence de la moitié de la suite = "+difference));
	  this.stats.add(new JLabel("Periodicite = "+periode));
	  


		this.stats.repaint();
  }

  public Map<String, JTextField> getParametres() {
	  return this.champsParametres;
  }
  
  
}