package NguyenVanSon_BT03;

import java.util.Scanner;

public class Taylor2 {
	private static Scanner scan;

	public static double cosh(double x, double epsilon) {

		double sum = 1;
		double term = 1;
		int i = 1;

		while (term > epsilon) {
			term = term * Math.pow(x, 2) / (2 * i * (2 * i - 1));
			sum = sum + term;
			i++;
		}
		return sum;

	}

	public static double cos(double x, double epsilon) {

		double sum = 1;
		double term = 1;
		int i = 1;

		while (Math.abs(term) > epsilon) {
			term = term * -Math.pow(x, 2) / (2 * i * (2 * i - 1));
			sum = sum + term;
			i++;
		}
		return sum;
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.print("Nhap x = ");
		double x = scan.nextDouble();
		System.out.print("Nhap sai so epsilon = ");
		double epsilon = scan.nextDouble();
		System.out.println("cosh(" + x + ") = " + cosh(x, epsilon));
		System.out.println("cos(" + x + ") = " + cos(x, epsilon));
	}
}