package Calcul;

public class SuiteBBS extends Analyse{
	
	private long p;
	private long q;
	/*
	 * taille = 1000
	 * p = 23
	 * q = 31
	 * x0 = 4
	 */
	
	public SuiteBBS(long p, long q, long x0 ,long taille ) {
		super(x0, p*q , taille);
		this.p = p;
		this.q = q;
		this.m = p*q;
	}
	
	public void genererSuite() {
	
		this.tabDesNombresGeneres[0] = this.x0;
		for ( int i = 1 ; i < this.taille ; i++ ) {
			System.out.println(this.tabDesNombresGeneres[i-1]);
			
			this.tabDesNombresGeneres[i] = (long) (Math.pow(this.tabDesNombresGeneres[i-1], 2) % this.m);
			
			System.out.println(this.tabDesNombresGeneres[i]);
			System.out.println();
		}
	}
	
	
}
