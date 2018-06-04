package UI;

import java.io.IOException;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Calcul.Doublet;
import Calcul.SuiteBBS;
import Calcul.SuitePseudoAleatoire;

public class Modele {
	
	private XYSeries serie;
	private SuitePseudoAleatoire g;
	
	public Modele() {
	}
	
	public void genererDonnee(int a, int b, int x0, int m, int taille) {

		this.g = new SuitePseudoAleatoire(a, b, x0, m, taille);
		//this.g= new SuiteBBS(23, 31,  16, 1000);
		 g.genererSuite();
		Doublet<Long>[] d = g.genererDoublets();
		    
		this.serie = new XYSeries("X0");
		
		
		
	   for(int i =0; i<d.length; i++) {
		   this.serie.add(d[i].getA(), d[i].getB());
		
		   System.out.println("MODELE | i = "+i+" a = "+d[i].getA()+" b = "+d[i].getB());
	   }
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
	
	public int getPeriode() {
		return g.periodicite();
	}
}

