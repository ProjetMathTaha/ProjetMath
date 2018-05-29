package Calcul;

public class GenerateurSuitePseudoAleatoire {

	// parametres de bases de calcule de la suite
	int a;
	int b;
	int x0;
	
	// modulo
	int m;
	
	// taille de la suite
	int taille;
	
	
	// tableau contenant le resultat de tous les nombres gener�s
	long[] tabDesNombresGeneres;
	
	// tableau contenant les doublets de nombres g�n�r�s
	Doublet<Long>[] tabDoublet;
	
	// tableau contenant les nombre gener� modulo deux
	int[] tabModDeux;
	
	public GenerateurSuitePseudoAleatoire(int a, int b, int x0, int m, int taille) {
		this.a = a;
		this.b = b;
		this.x0 = x0;
		this.m = m;
		this.taille = taille;
		this.tabDesNombresGeneres = new long[taille];
		this.tabDoublet = new Doublet[taille-1];
		
		// generation des nombres
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
	
	// methode qui genere un tableau  modulo 2 de la suite g�n�r� par la fonction
	public int[] genererTableauBinaire() {
		for ( int i = 0 ; i < this.taille ; i++ ) {
			this.tabModDeux[i] = (int) (this.tabDesNombresGeneres[i]%2);
		}
		return this.tabModDeux;
	}
	
	// calcul la fr�quence de 0 
	public float calculFrequence() {
		int nbZero = 0;
		for ( int i = 0 ; i < this.tabModDeux.length ; i++ ) {
			if ( this.tabModDeux[i] == 0)
				nbZero++;
		}
		return nbZero/this.tabModDeux.length;
	}
	
	// methode cree un tableau de doublet binaire
	public Doublet<Integer>[] genererTabDoubletBinaire() {
		Doublet<Integer>[] res = new Doublet[this.tabDesNombresGeneres.length-1];
		for ( int i = 0 ; i < this.tabDesNombresGeneres.length -1 ; i++ ) {
			res[i] = new Doublet<Integer>( (int) this.tabDesNombresGeneres[i]%2, (int) (this.tabDesNombresGeneres[i+1]%2));
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
	
	// methode qui renvoie la liste des nombres g�n�r�s
	public long[] getTabDesNombresGeneres() {
		return tabDesNombresGeneres;
	}



	// renvoie true si la suite respecte de le theoreme Hull-Dobell
	public boolean estHullDobell() {
		if ( GenerateurSuitePseudoAleatoire.pgcd(this.a, this.m) == 1 && 
				GenerateurSuitePseudoAleatoire.pgcd(this.b, this.m) == 1 && 
				this.estDiviseQuatre() )
			return true;
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
