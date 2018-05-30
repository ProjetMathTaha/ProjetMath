package UI;

import java.io.IOException;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Calcul.Doublet;
import Calcul.GenerateurSuitePseudoAleatoire;

public class Modele {
	
	private XYSeries serie;
	private GenerateurSuitePseudoAleatoire g;
	
	public Modele() {
	}
	
	public void genererDonnee(int a, int b, int x0, int m, int taille, int x1) {

		 this.g = new GenerateurSuitePseudoAleatoire(a, b, x0, m, taille);
		Doublet<Long>[] d = g.genererDoublets();
		    
		this.serie = new XYSeries("X0");
		
		
		
	   for(int i =0; i<d.length; i++) {
		   this.serie.add(d[i].getA(), d[i].getB());
		
		   System.out.println("MODELE | i = "+i+" a = "+d[i].getA()+" b = "+d[i].getB());
	   }
	    /*
	    this.serie.add(1, 72.9);
	    this.serie.add(2, 81.6);
	    this.serie.add(3, 88.9);
	    this.serie.add(4, 96);
	    this.serie.add(5, 102.1);
	    this.serie.add(6, 108.5);
	    this.serie.add(7, 113.9);
	    this.serie.add(8, 119.3);
	    this.serie.add(9, 123.8);
	    this.serie.add(10, 124.4);
*/

	  }
	
	public XYSeries getDonnee() {
	    return this.serie;
	}
	
	public float getFrequence() {
		System.out.println("reesryhtrhrt" + g.calculFrequenceDeZero());
		return g.calculFrequenceDeZero();
	}
	
	public float[] getFrequenceDoublets() {
		System.out.println("reesryhtrhrt" + g.calculerFrequenceDeZeroPar2());
		return g.calculerFrequenceDeZeroPar2();
	}
	
	public float getDifferenceMoitie() {
		return g.calculDifferenceMoitie();
	}
}

