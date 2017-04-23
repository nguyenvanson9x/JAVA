package vn.vnu.hus.backtracking;

import java.util.Scanner;

public class Horses {

	private static int n;
	private static final int[][] H = new int[100][100];
	private static final int[] A = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static final int[] B = { 1, 2, 2, 1, -1, -2, -2, -1 };
	private static Scanner input;

	public static void init(int n) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				H[i][j] = 0;
			}
		}

	}

	public static void print() {

		System.out.println("Cach xep ma:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d\t", H[i][j]);
			}
			System.out.println("");
		}

	}

	public static void move(int i, int x, int y) {

		for (int k = 0; k < 8; k++) {

			int newX = x + A[k];
			int newY = y + B[k];
			
			if (newX >= 0 && newX < n && newY >= 0 && newY < n && H[newX][newY] == 0) {

				H[newX][newY] = i;
				if (i < n * n) {
					move(i + 1, newX, newY);
				} else {
					print();
				}

				H[newX][newY] = 0;
			}
		}
	}

	public static void main(String[] args) {
		input = new Scanner(System.in);
		n = input.nextInt();
		input.close();
		
		init(n);
		move(0, 2, 2);
	}
}
