package demo;

import java.util.Scanner;

public class hoan_vi {
	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int n, i;

		System.out.print("Nhap do dai cua mang: ");
		n = scan.nextInt();
		int[] arr = new int[n];

		System.out.print("Nhap cac phan tu cua mang: ");
		for (i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		printHoanVi(arr);
	}

	private static void printHoanVi(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();

		int i = n - 1;
		while (i > 0) {
			i = n - 1;
			while (i > 0 && (arr[i] < arr[i - 1]))
				i--;
			if (i > 0) {
				int k;
				for (k = n - 1; k >= i; k--) {
					if (arr[k] > arr[i - 1])
						break;
				}
				swap(arr, k, i - 1);
				for (int m = i; m < i + (n - i) / 2; m++) {
					swap(arr, m, n - 1 - m + i);
				}
				for (k = 0; k < n; k++) {
					System.out.print(arr[k]);
				}
				System.out.println();
			}
		}
	}

	private static void swap(int[] a, int k, int i) {
		int t;
		t = a[k];
		a[k] = a[i];
		a[i] = t;
	}
}
