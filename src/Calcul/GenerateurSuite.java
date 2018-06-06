package Calcul;

import java.util.HashSet;
import java.util.Set;

public abstract class GenerateurSuite {
	
	
	long[] tabDesNombresGeneres;		// tableau contenant le resultat de tous les nombres generes
	int[] tabModDeux;					// tableau contenant les nombre generes modulo deux

	public GenerateurSuite(long x0, long modulo, int taille) {
		this.tabDesNombresGeneres = new long[taille];
		this.tabModDeux = new int[taille];
	}

	
	// methode qui renvoi le tableau de doublets des nombres decimaux
	public Doublet<Long>[] genererDoublets() {
		Doublet<Long>[] tabDoublets = new Doublet[this.tabDesNombresGeneres.length -1];
		for ( int i = 0; i < this.tabDesNombresGeneres.length - 1 ; i++ ) {
			tabDoublets[i] = new Doublet<Long>(this.tabDesNombresGeneres[i], this.tabDesNombresGeneres[i+1]);
		}
		return tabDoublets;
	}
	
	// methode qui genere un tableau modulo 2 de la suite genere par la fonction
	public int[] genererTableauBinaire() {
		for (int i = 0; i < this.tabDesNombresGeneres.length; i++) {
			this.tabModDeux[i] = (int) (this.tabDesNombresGeneres[i] % 2);
		}
		return this.tabModDeux;
	}
	
	// methode cree un tableau de doublet binaire
	public Doublet<Integer>[] genererTabDoubletBinaire() {
		Doublet<Integer>[] res = new Doublet[this.tabDesNombresGeneres.length - 1];
		for (int i = 0; i < this.tabDesNombresGeneres.length - 1; i++) {
			res[i] = new Doublet<Integer>((int) (this.tabDesNombresGeneres[i] % 2),
					(int) (this.tabDesNombresGeneres[i + 1] % 2));
		}
		return res;
	}
	
	// methode qui calcul les frequence
	public float calculFrequenceDeZero() {
		float res = 0;
		int[] tab = this.genererTableauBinaire();
		for (int i : tab) {
			if (i == 0)
				res++;
		}
		return res / tab.length;
	}
	
	// genere un tableau des 4 frequences 00, 01, 10, 11
	public float[] calculerFrequenceDeZeroPar2() {
		Doublet<Integer>[] tab = this.genererTabDoubletBinaire();
		float[] nbTotal = { 0F, 0F, 0F, 0F };
		for (Doublet<Integer> d : tab) {
			if (d.getA() == 0 && d.getB() == 0) {
				nbTotal[0] += 1.0F;
			} else if (d.getA() == 0 && d.getB() == 1) {
				nbTotal[1] += 1.0F;
			} else if (d.getA() == 1 && d.getB() == 0) {
				nbTotal[2] += 1.0F;
			} else if (d.getA() == 1 && d.getB() == 1) {
				nbTotal[3] += 1.0F;
			}
		}
		for (int i = 0; i < nbTotal.length; i++) {
			nbTotal[i] = nbTotal[i] / tab.length;
		}
		return nbTotal;
	}

	// methode qui compare les 2 moitiés de la suite binaire générée
	public float calculDifferenceMoitie() {
		float res = 0;
		for (int i = 0; i < this.tabModDeux.length / 2; i++) {
			if (this.tabModDeux[i] != this.tabModDeux[this.tabModDeux.length / 2 + i])
				res++;
		}
		return res / (this.tabModDeux.length / 2);
	}
	
	public int periodicite() {
		Set<Long> periode = new HashSet<>();
		for ( Long l : this.tabDesNombresGeneres)
			periode.add(l);
		return periode.size();
	}
	
	public long[] getNbr() {
		return this.tabDesNombresGeneres;
	}
	
	
	
}
