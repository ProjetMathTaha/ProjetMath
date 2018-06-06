package Calcul;

public class BBS extends GenerateurSuite {

	public BBS(long x0, long modulo, int taille) {
		super(x0, modulo, taille);
		genererSuite(x0, taille, modulo);
		
	}

	private void genererSuite(long x0, int taille, long modulo) {
		this.tabDesNombresGeneres[0] = x0;
		for ( int i = 1 ; i < taille ; i++ ) {
			this.tabDesNombresGeneres[i] = (long) (Math.pow(this.tabDesNombresGeneres[i-1], 2) % modulo);
		}
	}

}
