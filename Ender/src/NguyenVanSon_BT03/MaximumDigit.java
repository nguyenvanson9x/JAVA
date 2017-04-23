package NguyenVanSon_BT03;

import java.util.Scanner;

public class MaximumDigit {
	private static Scanner scan;

	public static int getMaximumDigit(int n) {

		String s = String.valueOf(n);
		int l = s.length();
		int i, p;
		int max = Integer.MIN_VALUE;

		for (i = 0; i < l; i++) {
			p = (int) (n % (Math.pow(10, l - i)) / Math.pow(10, l - i - 1));
			if (p > max)
				max = p;
		}
		return max;

	}

	public static int getSumDigit(int n) {
		int sum = 0;

		String s = String.valueOf(n);
		int l = s.length();
		int i, p;
		for (i = 0; i < l; i++) {
			p = (int) (n % (Math.pow(10, l - i)) / Math.pow(10, l - i - 1));
			sum += p;
		}
		return sum;

	}

	public static void printStars() {
		for (int i = 1; i <= 20; i++) {
			System.out.print("*");

		}
		System.out.println();
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Nhap n = ");
		int n = scan.nextInt();
		printStars();
		System.out.println(getMaximumDigit(n));
		System.out.println(getSumDigit(n));
		printStars();
	}
}
