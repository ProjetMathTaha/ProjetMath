import java.math.BigInteger;

public class Suite1 {
	
	public static void main(String [] args) {
		long x0 =43278;
		long a =2;
		long b =1;
		int moyenne = 0;
		for ( int i = 0 ; i < 100 ; i++) {
			x0 = gener(x0, a, b);
			
			
			//System.out.println(x0);
			//System.out.println(calculNb1(x0));
			System.out.printf("%027d \n", new BigInteger(Long.toBinaryString((long)x0)));
			
			moyenne += calculNb1(x0);
			
			//System.out.printf("%32d",d);

		}
		System.out.println(moyenne/100);
	}

	public static long gener(long x0, long a, long b) {
		long m = (long) Math.pow(10, 8);
		long x = x0;
		
		return (a*x + b)%m;
	}

	public static int calculNb1(long x0) {
		String x = Long.toBinaryString(x0);
		int j =0;
		for(int i = 0; i < x.length(); i++ ) {
			if(x.charAt(i) == '1')
				j++;
		}
		return j;
	}
}
