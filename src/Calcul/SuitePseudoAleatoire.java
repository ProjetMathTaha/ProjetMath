package Calcul;

import java.util.HashSet;
import java.util.Set;

public class SuitePseudoAleatoire extends Analyse {

	// parametres de bases de calcule de la suite
	long a;
	long b;
	
	// modulo
	
	// taille de la suite

	public SuitePseudoAleatoire(long a, long b , long x0, long m, long taille) {
		super(x0,m,taille);
		this.a = a;
		this.b = b;
	}

	public void genererSuite() {
		tabDesNombresGeneres[0] = this.x0;
		for ( int i = 1 ; i < this.taille ; i++ ) {
			this.x0 = (this.a*this.x0 + this.b)%this.m;
			tabDesNombresGeneres[i]=this.x0;
			System.out.println( x0);
		}
	}
	
	public int periodicite() {
		Set<Long> periode = new HashSet<>();
		for ( Long l : this.tabDesNombresGeneres)
			periode.add(l);
		return periode.size();
	}
	
	// renvoie true si la suite respecte de le theoreme Hull-Dobell
	public boolean estHullDobell() {
		if ( SuitePseudoAleatoire.pgcd(this.a, this.m) == 1 && 
				SuitePseudoAleatoire.pgcd(this.b, this.m) == 1 && 
				this.estDiviseQuatre() &&
				this.estDivisbleParP())
			return true;
		return false;
	}
	
	private boolean estDivisbleParP() {
		// TODO Auto-generated method stub
		return false;
	}

	// verifie une des conditions du th�oree Hull-Dobell
	private  boolean estDiviseQuatre() {
		boolean res = true;
		if ( this.m%4 == 0 && (this.a - 1 )%4 != 0 )
			res = false;
		return res;
	}
	
	// calcule le pgcd de 2 nombres pass�s en parametres
	private static long pgcd(long a, long b) {
		long r;
		if ( a > b ) {
			long aux = a;
			a = b;
			b = aux;
		}
		do {
			r = b%a;
			b = a;
			a = r;
		} while ( r != 0 );
		return b;
	}
}
