package vn.vnu.hus.backtracking;

import java.util.Scanner;

public class NumericalAnalysis {

	private static final int X[] = new int[100];
	private static final int SUM[] = new int[100];
	private static int n;
	private static Scanner input;

	public static void printResult(int k) {

		for (int i = 1; i <= k; i++) {
			System.out.printf("%d\t", X[i]);
		}
		System.out.println("");
	}

	public static void find(int i) {

		for (int j = X[i - 1]; j <= (n - SUM[i - 1]) / 2; j++) {
			X[i] = j;
			SUM[i] = SUM[i - 1] + X[i];
			find(i + 1);
		}
		X[i] = n - SUM[i - 1];
		printResult(i);
	}

	public static void main(String[] args) {

		System.out.println("Nhap n: ");
		input = new Scanner(System.in);
		n = input.nextInt();
		input.close();

		X[0] = 1;
		SUM[0] = 0;
		find(1);
	}
}
