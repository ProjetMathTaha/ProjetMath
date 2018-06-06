package Calcul;

public class CongruentielLineaire extends GenerateurSuite {

	public CongruentielLineaire(long a, long b, long x0, long modulo, int taille) {
		super(x0, modulo, taille);
		genererSuite(x0, taille, modulo, a, b);
	}
	
	private void genererSuite(long x0, int taille, long modulo, long a, long b) {
		tabDesNombresGeneres[0] = x0;
		for ( int i = 1 ; i < taille ; i++ ) {
			x0 = (a*x0 + b)%modulo;
			tabDesNombresGeneres[i]= x0;
		}
	}

}
