import java.util.Scanner;

public class Fibonacci {
	private static Scanner scan;

	public static int recursiveFibo(int n) {

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {

			return (recursiveFibo(n - 1) + recursiveFibo(n - 2));
		}

	}

	public static void printStars() {

		for (int i = 1; i <= 20; i++) {
			System.out.print("*");

		}
		System.out.println();
	}

	public static int loopFibo(int n) {

		int i, f1, f2;
		f1 = 0;
		f2 = 1;
		for (i = 1; i <= n; i++) {
			f2 = f2 + f1;
			f1 = f2 - f1;

		}

		return f1;

	}

	public static void main(String[] args) {

		scan = new Scanner(System.in);
		System.out.print("Nhap n = ");
		int n = scan.nextInt();
		printStars();
		System.out.println("So fibonaci thu " + n + " la: " + recursiveFibo(n));
		System.out.println("So fibonaci thu " + n + " la: " + loopFibo(n));
		printStars();

	}

}
