import Calcul.Doublet;
import Calcul.GenerateurSuitePseudoAleatoire;
import Calcul.SuitePseudoAleatoire;

public abstract class test {

	public static void main(String[] args) {
		SuitePseudoAleatoire g = new SuitePseudoAleatoire(4377, 1, 3, 2000, 20);
		g.genererSuite();
		System.out.println("resultat :"+g.periodicite());
		 
		
	}

}
