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
	
	private Map<String, JTextField> champsParametresCongruenceLineaire; // contient les JTextField des parametres de la congruence lineaire
	private Map<String, JTextField> champsParametresBBS; // contient les JTextField des parametres de la congruence lineaire
	private JButton validerCongruenceLineaire;	// bouton pour lancer les calculs par la methode de congruence lineaire
	private JButton validerBBS;	// bouton pour lancer les calculs par la methode BBS
  	private JPanel parametres ;// contient les parametres ï¿½ entrer par l'utilisateur
  	private JPanel graphs; // contient les graphs
  	private JPanel stats ; // contient les stats
 
  public Vue() { 
	  
	  	Controleur controleur = new Controleur(this);
	  
	  	// instantiation des attributs de la classe
	  	this.champsParametresCongruenceLineaire = new HashMap<>();
	  	this.champsParametresBBS = new HashMap<>();
	  
	  	// creation de 3 panels et ajout du layout a la classe
	    this.setLayout(new BorderLayout());
	  	this.parametres = new JPanel(); // contient les parametres ï¿½ entrer par l'utilisateur
	  	this.graphs = new JPanel(); // contient les graphs
	  	this.stats = new JPanel(); // contient les stats
	  	
	  	this.add(parametres, BorderLayout.NORTH);
	  	this.add(graphs, BorderLayout.CENTER);
	  	this.add(stats, BorderLayout.SOUTH);
	  	
	  	
	  	
	  	// panel des parametres
	  	parametres.setLayout(new GridLayout(2, 2));
  		// panel qui contient les textfield pour entrer les valeurs de la methode de congruence lineaire
  		JPanel parametresValeursCongruenceLineaire = new JPanel();
  		parametres.add(parametresValeursCongruenceLineaire);
  		parametresValeursCongruenceLineaire.setLayout(new GridLayout(1, 10));
  		
  		JLabel jlabelA = new JLabel("a :");
  		jlabelA.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeursCongruenceLineaire.add(jlabelA);
  		champsParametresCongruenceLineaire.put("a", new JTextField("314125421"));
  		parametresValeursCongruenceLineaire.add(champsParametresCongruenceLineaire.get("a"));
  		
  		JLabel jlabelB = new JLabel("b :");
  		jlabelB.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeursCongruenceLineaire.add(jlabelB);
  		champsParametresCongruenceLineaire.put("b", new JTextField("1"));
  		parametresValeursCongruenceLineaire.add(champsParametresCongruenceLineaire.get("b"));
  		
  		JLabel jlabelX0 = new JLabel("x0 :");
  		jlabelX0.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeursCongruenceLineaire.add(jlabelX0);
  		champsParametresCongruenceLineaire.put("x0", new JTextField("4327"));
  		parametresValeursCongruenceLineaire.add(champsParametresCongruenceLineaire.get("x0"));
  		
  		JLabel jlabelM = new JLabel("m :");
  		jlabelM.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeursCongruenceLineaire.add(jlabelM);
  		champsParametresCongruenceLineaire.put("m", new JTextField("2675591"));
  		parametresValeursCongruenceLineaire.add(champsParametresCongruenceLineaire.get("m"));
  		
  		JLabel jlabelNB = new JLabel("nb :");
  		jlabelNB.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeursCongruenceLineaire.add(jlabelNB);
  		champsParametresCongruenceLineaire.put("nb", new JTextField("20001"));
  		parametresValeursCongruenceLineaire.add(champsParametresCongruenceLineaire.get("nb"));
  		
  		// panel qui contient les textfield pour entrer les valeurs de la methode de congruence lineaire
  		JPanel parametresValeursBBS = new JPanel();
  		parametres.add(parametresValeursBBS);
  		parametresValeursBBS.setLayout(new GridLayout(1, 6));
  		
  		JLabel jlabelX0_BBS = new JLabel("x0 :");
  		jlabelX0_BBS.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeursBBS.add(jlabelX0_BBS);
  		champsParametresBBS.put("x0", 
  				new JTextField("4327"));
  		parametresValeursBBS.add(champsParametresBBS.get("x0"));
  		
  		JLabel jlabelM_BBS = new JLabel("m :");
  		jlabelM_BBS.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeursBBS.add(jlabelM_BBS);
  		champsParametresBBS.put("m", new JTextField("2675591"));
  		parametresValeursBBS.add(champsParametresBBS.get("m"));
  		
  		JLabel jlabelNB_BBS = new JLabel("nb :");
  		jlabelNB_BBS.setHorizontalAlignment(SwingConstants.CENTER);
  		parametresValeursBBS.add(jlabelNB_BBS);
  		champsParametresBBS.put("nb", new JTextField("20001"));
  		parametresValeursBBS.add(champsParametresBBS.get("nb"));
  		
  		
  		// le bouton valider congruence lineaire
  		this.validerCongruenceLineaire = new JButton("Calculer en Congruence Linéaire");
  		this.validerCongruenceLineaire.setMnemonic(1);
  		this.validerCongruenceLineaire.addActionListener(controleur);
  		parametres.add(this.validerCongruenceLineaire);
  		
		// le bouton valider
  		this.validerBBS = new JButton("Calculer en Congruence Linéaire");
  		this.validerBBS.setMnemonic(0);
  		this.validerBBS.addActionListener(controleur);
  		parametres.add(this.validerBBS);
	    
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

  public Map<String, JTextField> getParametresCongruenceLineaire() {
	  return this.champsParametresCongruenceLineaire;
  }
  public Map<String, JTextField> getParametresBBS() {
	  return this.champsParametresBBS;
  }
  
  
  
}