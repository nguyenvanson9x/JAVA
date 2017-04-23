import java.util.Scanner;

public class Facrorial {
	private static Scanner scan;

	public static long loopFactorial(int n) {
		long kq = 1;
		for (int i = 2; i <= n; i++) {
			kq = kq * i;
		}
		return kq;

	}

	public static long recursiveFactorial(int n) {

		if (n == 1) {
			return 1;
		} else

			return n * recursiveFactorial(n - 1);

	}

	public static void printStars() {
		for (int i = 1; i <= 20; i++) {
			System.out.print("*");

		}
		System.out.println();
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.print("Nhap vao so n = ");
		int n = scan.nextInt();
		printStars();
		System.out.println("" + n + "! = " + loopFactorial(n));
		System.out.println("" + n + "! = " + recursiveFactorial(n));
		printStars();

	}
}
