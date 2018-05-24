
public class GenerateurSuitePseudoAleatoire {

	// parametres de bases de calcule de la suite
	int a;
	int b;
	int x0;
	
	// modulo
	int m;
	
	// taille de la suite
	int taille;
	
	// ???
	int x1;
	
	// tableau contenant le resultat de tous les nombres generés
	long[] tabDesNombresGeneres;
	
	// tableau contenant les doublets de nombres générés
	Doublet<Long>[] tabDoublet;
	
	// tableau contenant les nombre generé modulo deux
	int[] tabModDeux;
	
	public GenerateurSuitePseudoAleatoire(int a, int b, int x0, int m, int taille, int x1) {
		this.a = a;
		this.b = b;
		this.x0 = x0;
		this.m = m;
		this.taille = taille;
		this.x1 = x1;
		this.tabDesNombresGeneres = new long[taille];
		this.tabDoublet = new Doublet[taille-1];
		
		// generation des nombres
		tabDesNombresGeneres[0] = this.x0;
		for ( int i = 1 ; i < taille ; i++ ) {
			this.x0 = (a*x0 + b)%m;
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
	
	// methode qui genere un tableau  modulo 2 de la suite généré par la fonction
	public int[] genererTableauBinaire() {
		for ( int i = 0 ; i < this.taille ; i++ ) {
			this.tabModDeux[i] = (int) (this.tabDesNombresGeneres[i]%2);
		}
		return this.tabModDeux;
	}
	
	// calcul la fréquence de 0 
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
	
	
	// methode qui renvoie la liste des nombres générés
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
	
	// verifie une des conditions du théoree Hull-Dobell
	private  boolean estDiviseQuatre() {
		boolean res = true;
		if ( this.m%4 == 0 && (this.a - 1 )%4 != 0 )
			res = false;
		return res;
	}
	
	// calcule le pgcd de 2 nombres passés en parametres
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
