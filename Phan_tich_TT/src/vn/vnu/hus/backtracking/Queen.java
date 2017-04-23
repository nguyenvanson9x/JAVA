package vn.vnu.hus.backtracking;

import java.util.Scanner;

public class Queen {

	private static final int[] A = new int[100];
	private static final int[] B = new int[100];
	private static final int[] C = new int[100];
	private static final int[] X = new int[100];
	private static Scanner input;

	public static void print(int x[], int n) {

		for (int i = 0; i < n; i++) {
			System.out.printf("%d\t", x[i] + 1);
		}
		System.out.println(" ");
	}

	public static void init(int n) {

		for (int i = 0; i < n; i++) {
			A[i] = 1;
		}

		for (int i = 0; i < 2 * n - 1; i++) {
			B[i] = 1;
			C[i] = 1;
		}

	}

	public static void queen(int i, int n) {

		for (int j = 0; j < n; j++) {
			if (A[j] == 1 && B[i - j + n - 1] == 1 && C[i + j] == 1) {

				X[i] = j;
				A[j] = 0;
				B[i - j + n - 1] = 0;
				C[i + j] = 0;
				if (i == n - 1) {
					print(X, n);
				} else {
					queen(i + 1, n);
				}
				A[j] = 1;
				B[i - j + n - 1] = 1;
				C[i + j] = 1;
			}

		}
	}

	public static void main(String[] args) {
		int n;
		input = new Scanner(System.in);
		System.out.println("Nhap kich thuoc ban co:");
		n = input.nextInt();
		input.close();
		init(n);
		System.out.println("cac cach xep hau: ");
		queen(0, n);

	}

}
