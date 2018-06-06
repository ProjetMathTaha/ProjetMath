package UI;

import org.jfree.data.xy.XYSeries;

import Calcul.BBS;
import Calcul.CongruentielLineaire;
import Calcul.Doublet;


public class Modele {
	
	private XYSeries serie;
	private CongruentielLineaire g;
	private BBS bbs;
	
	public Modele() {
	}
	
	public void genererDonneeCongruenceLineaire(int a, int b, int x0, int m, int taille) {

		this.g = new CongruentielLineaire(a, b, x0, m, taille);
		Doublet<Long>[] d = g.genererDoublets();
		this.serie = new XYSeries("X0");
		for (int i = 0; i < d.length; i++) {
			this.serie.add(d[i].getA(), d[i].getB());
			System.out.println("MODELE | i = " + i + " a = " + d[i].getA() + " b = " + d[i].getB());
		}
	  }
	
	public void genererDonneeBBS(int a, int b, int x0, int m, int taille) {
		
		this.g = new CongruentielLineaire(a, b, x0, m, taille);
		Doublet<Long>[] d = g.genererDoublets();
		this.serie = new XYSeries("X0");
		for (int i = 0; i < d.length; i++) {
			this.serie.add(d[i].getA(), d[i].getB());
			System.out.println("MODELE | i = " + i + " a = " + d[i].getA() + " b = " + d[i].getB());
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

