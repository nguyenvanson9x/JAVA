package vn.vnu.hus.backtracking;

import java.util.Scanner;

public class SubSets {

	private static int n;
	private static int k;
	private static final int X[] = new int[100];
	private static Scanner input;

	public static void printResult() {

		for (int i = 1; i <= k; i++) {

			System.out.printf("%d\t", X[i]);
		}
		System.out.println("");
	}

	public static void sets(int i) {

		for (int j = X[i - 1] + 1; j <= n - k + i; j++) {
			X[i] = j;
			if (i == k) {
				printResult();
			} else {
				sets(i + 1);
			}
		}
	}

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Nhap n: ");
		n = input.nextInt();
		System.out.println("Nhap k: ");
		k = input.nextInt();
		input.close();
		X[0] = 0;
		System.out.println("Cac tap con " + k + " phan tu cua tap " + n + " phan tu la");
		sets(1);
	}

}
