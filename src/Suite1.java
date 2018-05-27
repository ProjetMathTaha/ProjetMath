import Calcul.Doublet;

public class Suite1 {
	
	public static void main(String [] args) {
		long x0 =43277;
		long x1;
		long a =2;
		long b =1;
		long[] tabNb = new long[100]; // tableau contenant les nbr gener�s
		Doublet<Long>[] tabDoublet = new Doublet[100]; // tableau contenant les doublets
		int[] tabModDeux = new int[100]; // tableau des nombres modulo 2 
		Doublet<Integer>[] tabDoubletModDeux = new Doublet[100];
		
		// ranger dans les tableau x0
		tabNb[0]=x0;
		tabModDeux[0]=(int) (x0%2);
		
		for ( int i = 1 ; i < 100 ; i++) {
			// generation du nb aleatoire
			x1 = generLineaire(x0, a, b);
			// le nb est rang� dans le tableau
			tabNb[i]= x1;
			
			// creation des doublet de chiffre, rang� dans un tableau
			tabDoublet[i] = new Doublet<Long>(x0, x1);
			
			// ratio des nb en binaire 2 par 2 
			tabDoubletModDeux[i] = new Doublet<Integer>((int)x0%2, (int)x1%2);
			
			// tranfert
			x0=x1;
			
			// passer les nb en mod 2 
			tabModDeux[i] = (int) (x1%2);
			
			
		}
	}

	public static long generLineaire(long x0, long a, long b) {
		long m = (long) Math.pow(10, 8);
		long x = x0;
		
		return (a*x + b)%m;
	}
	
}