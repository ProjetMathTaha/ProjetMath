
public class Suite1 {
	
	public static void main(String [] args) {
		double x0 =1;
		double a =314125421;
		double b =1;
		System.out.println( gener(x0, a, b));
	}

	public static double gener(double x0, double a, double b) {
		double m = Math.pow(10, 8);
		double x = x0;
		for( double i = 0; i < m ; i++ ) {
			x = a*x+b;
		}
		return x;
	}
}
