package vn.vnu.hus.backtracking;

import java.util.Scanner;

public class CreateBinary {

	private static Scanner input;

	public static void print(int a[], int n) {
		int i;
		for (i = 0; i < n; i++) {
			System.out.print(a[i]);
		}
		System.out.println("");
	}

	public static void generateBinaryArray(int a[], int i, int n) {

		for (int j = 0; j <= 1; j++) {
			a[i] = j;
			if (i == n - 1) {
				print(a, n);
			} else {
				generateBinaryArray(a, i + 1, n);
			}
		}
	}

	public static void main(String[] args) {
		int n;
		System.out.println("Nhap do dai day nhi phan: ");
		input = new Scanner(System.in);
		n = input.nextInt();
		input.close();
		
		int a[] = new int[n];
		System.out.println("Cac day nhi phan co do dai: " + n);
		generateBinaryArray(a, 0, n);

	}

}
