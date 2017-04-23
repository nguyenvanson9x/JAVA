import java.util.Scanner;

public class Conversion {
	private static Scanner scan;

	public static void printStars() {
		for (int i = 1; i <= 20; i++) {
			System.out.print("*");

		}
		System.out.println();
	}

	public static String classifyFluid(double x) {
		String s = "";
		if (x > 40) {
			System.out.println("Extra strong liquor");
		} else if (x > 20) {
			System.out.println("Strong liquor");
		} else if (x > 15) {
			System.out.println("Liquor");
		} else if (x > 12) {
			System.out.println("Strong vine");
		} else if (x > 10.5) {
			System.out.println("Normal vine");
		} else
			System.out.println("Light vine");
		return s;
	}

	public static void main(String[] args) {
		System.out.print("Nhap vao nong do con, n = ");
		double n;
		scan = new Scanner(System.in);
		n = scan.nextDouble();
		printStars();
		classifyFluid(n);
		printStars();
	}
}