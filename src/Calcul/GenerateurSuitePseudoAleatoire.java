package Calcul;

public class GenerateurSuitePseudoAleatoire {

	// parametres de bases de calcule de la suite
	long a;
	long b;
	long x0;
	
	// modulo
	long m;
	
	// taille de la suite
	long taille;
	
	
	// tableau contenant le resultat de tous les nombres generï¿½s
	long[] tabDesNombresGeneres;
	
	// tableau contenant les doublets de nombres gï¿½nï¿½rï¿½s
	Doublet<Long>[] tabDoublet;
	
	// tableau contenant les nombre generï¿½ modulo deux
	int[] tabModDeux;
	
	public GenerateurSuitePseudoAleatoire(long a, long b, long x0, long m, long taille) {
		this.a = a;
		this.b = b;
		this.x0 = x0;
		this.m = m;
		this.taille = taille;
		this.tabDesNombresGeneres = new long[(int) taille];
		this.tabDoublet = new Doublet[(int) (taille-1)];
		this.tabModDeux = new int[(int) taille];
		genererClassique(taille);
	}

	private void genererClassique(long taille) {
		tabDesNombresGeneres[0] = this.x0;
		for ( int i = 1 ; i < taille ; i++ ) {
			this.x0 = (this.a*this.x0 + this.b)%this.m;
			tabDesNombresGeneres[i]=this.x0;
		}
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

	// renvoie true si la suite respecte de le theoreme Hull-Dobell
	public boolean estHullDobell() {
		if ( GenerateurSuitePseudoAleatoire.pgcd(this.a, this.m) == 1 && 
				GenerateurSuitePseudoAleatoire.pgcd(this.b, this.m) == 1 && 
				this.estDiviseQuatre() &&
				this.estDivisbleParP())
			return true;
		return false;
	}
	
	private boolean estDivisbleParP() {
		// TODO Auto-generated method stub
		return false;
	}

	// verifie une des conditions du thï¿½oree Hull-Dobell
	private  boolean estDiviseQuatre() {
		boolean res = true;
		if ( this.m%4 == 0 && (this.a - 1 )%4 != 0 )
			res = false;
		return res;
	}
	
	// calcule le pgcd de 2 nombres passï¿½s en parametres
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
