package UI;

import Calcul.CongruentielLineaire;

public class test {

	public static void main(String[] args) {

		CongruentielLineaire c = new CongruentielLineaire(4327, 2675591, 20001, 314125421, 1);
		int[] tab = c.genererTableauBinaire();
		for ( long l : tab )
			System.out.println(l);
	}

}
