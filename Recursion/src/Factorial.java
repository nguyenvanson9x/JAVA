public class Factorial {

	int factorial(int n) {
		if (n <= 0)
			return 1;
		else
			return n * factorial(n-1);
	}
	public static void main(String[] args) {
		System.out.println(new Factorial().factorial(10));
	}
}
