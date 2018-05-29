import Calcul.Doublet;
import Calcul.GenerateurSuitePseudoAleatoire;

public abstract class test {

	public static void main(String[] args) {
		GenerateurSuitePseudoAleatoire g = new GenerateurSuitePseudoAleatoire(4377, 1, 3, 20, 20, 6);
		Doublet<Long> d[] = g.genererDoublets();
		 
		/*for(int i =0; i<d.length; i++) {
			   System.out.println(" | i = "+i+" a = "+d[i].getA()+" b = "+d[i].getB());
		   }*/
		 
		//System.out.println(g.pgcd(7, 3));
	}

}
