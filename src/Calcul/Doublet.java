package Calcul;
public class Doublet<T> {
		private T a;
		private T b;
		
		public Doublet(T a, T b) {
			this.a = a;
			this.b = b;
		}
		public T getA() {
			return a;
		}
		public T getB() {
			return b;
		}
	}