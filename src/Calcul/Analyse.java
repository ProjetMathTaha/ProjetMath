package Calcul;

public class Analyse {

	
	// tableau contenant les doublets de nombres gï¿½nï¿½rï¿½s
		Doublet<Long>[] tabDoublet;
		
		// tableau contenant les nombre generï¿½ modulo deux
		int[] tabModDeux;
		
		// tableau contenant le resultat de tous les nombres generï¿½s
		long[] tabDesNombresGeneres;
		
		// taille de la suite
		long taille;
		
		long x0;
		long m;

		public Analyse( long x0, long m, long taille) {
			this.tabDesNombresGeneres = new long[(int) taille];
			this.tabDoublet = new Doublet[(int) (taille-1)];
			this.tabModDeux = new int[(int) taille];
			this.taille = taille;
			this.x0 = x0;
			this.m = m;

		}
		
		// methode qui renvoie des paires de nombres ( doublets )
		public Doublet<Long>[] genererDoublets() {
			for ( int i = 0; i < this.tabDoublet.length ; i++ ) {
				this.tabDoublet[i] = new Doublet<Long>(this.tabDesNombresGeneres[i], this.tabDesNombresGeneres[i+1]);
			}
			return this.tabDoublet;
		}
		
		// methode qui genere un tableau  modulo 2 de la suite gï¿½nï¿½rï¿½ par la fonction
		public int[] genererTableauBinaire() {
			for ( int i = 0 ; i < this.taille ; i++ ) {
				this.tabModDeux[i] = (int) (this.tabDesNombresGeneres[i]%2);
			}
			return this.tabModDeux;
		}
		
		// methode cree un tableau de doublet binaire
		public Doublet<Integer>[] genererTabDoubletBinaire() {
			Doublet<Integer>[] res = new Doublet[this.tabDesNombresGeneres.length-1];
			for ( int i = 0 ; i < this.tabDesNombresGeneres.length -1 ; i++ ) {
				res[i] = new Doublet<Integer>( (int) (this.tabDesNombresGeneres[i]%2), (int) (this.tabDesNombresGeneres[i+1]%2));
			}
			return res;
		}
		
		// methode qui calcul les frequence  
		public float calculFrequenceDeZero() {
			float res = 0;
			int[] tab = this.genererTableauBinaire();
			for ( int i : tab) {
				if ( i == 0 )
					res++;
			}
			return res/tab.length;	
		}
		
		// genere un tableau des 4 frequences 00, 01, 10, 11
		public float[] calculerFrequenceDeZeroPar2() {
			Doublet<Integer>[] tab = this.genererTabDoubletBinaire();
			float[] nbTotal = {0F, 0F, 0F, 0F};
			for ( Doublet<Integer> d : tab) {
				if ( d.getA() == 0 && d.getB() == 0) {
					nbTotal[0]+=1.0F;
				}
				else if ( d.getA() == 0 && d.getB() == 1 ) {
					nbTotal[1]+=1.0F;
				}
				else if ( d.getA() == 1 && d.getB() == 0 ) {
					nbTotal[2]+=1.0F;
				}
				else if ( d.getA() == 1 && d.getB() == 1 ) {
					nbTotal[3]+=1.0F;
				} else {
					
				}
			}
			for  (int i = 0 ; i < nbTotal.length ; i++) {
				nbTotal[i] = nbTotal[i]/tab.length;
			}
			return nbTotal;
		}
		
		//methode qui compare les 2 moitiés de la suite binaire générée
		public float calculDifferenceMoitie() {
			float res = 0;
			for ( int i = 0 ; i < this.tabModDeux.length / 2 ; i++ ) {
				if ( this.tabModDeux[i] != this.tabModDeux[this.tabModDeux.length/2+i])
					res++;
			}
			return res/(this.tabModDeux.length/2);
			
		}
		
		// methode qui renvoie la liste des nombres gï¿½nï¿½rï¿½s
		public long[] getTabDesNombresGeneres() {
			return tabDesNombresGeneres;
		}

		
}
