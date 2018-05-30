package Calcul;

public class GenerateurBBS extends Analyse{
	
	private int p;
	private int q;
	private int n;
	private int x0;
	
	private long[] suite;
	
	public GenerateurBBS() {
		this.suite = new long[1000];
		this.p = 23;
		this.q = 31;
		this.n= this.p * this.q ;
		this.x0 = 4;
	}
	
	public void gener() {
		this.suite[0] = this.x0;
		for ( int i = 1 ; i < 1000 ; i++ ) {
			this.suite[i] = (this.suite[i-1]*this.suite[i-1]) % this.n;
		}
	}
	
	
}
