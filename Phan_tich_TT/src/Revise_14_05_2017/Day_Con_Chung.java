package Revise_14_05_2017;

import java.util.Stack;

public class Day_Con_Chung {
	private static int n, m, C = 1;
	private static int[] a = { 7, 10, 4, 5, 5, 6, 12 };
	private static int[] b = { 1, 10, 12, 0, 5, 4, 6 };
	private static int[][] L;
	private static Stack<Integer> s = new Stack<Integer>();

	public static void main(String[] args) {
		n = a.length;
		m = b.length;
		L = new int[n + 1][m + 1];
		Day_Con();
		//show();
	}

	private static void Day_Con() {
		int i, j;
		for (i = 0; i <= n; i++)
			L[i][0] = 0;
		for (j = 0; j <= m; j++)
			L[0][j] = 0;
		for (i = 0; i < n; i++)
			for (j = 0; j < m; j++) {
				if (a[i] == b[j])
					L[i + C][j + C] = L[i - 1 + C][j - 1 + C] + 1;
				else
					L[i + C][j + C] = max(L[i + C][j - 1 + C], L[i - 1 + C][j + C], L[i - 1 + C][j - 1 + C]);
			}
		i = n;
		j = m;
		while (i != 0 && j != 0) {
			if (a[i - C] == b[j - C]) {
				s.push(a[i - C]);
				i--;
				j--;
			} else {
				if (L[i][j] == L[i - 1][j])
					i--;
				if (L[i][j] == L[i][j - 1])
					j--;
			}
		}
		for (int k : s) {
			System.out.print(k + " ");
		}
		System.out.println();
	}

	private static int max(int i, int j, int k) {
		// TODO Auto-generated method stub
		int temp[] = { i, j, k };
		int h, max = Integer.MIN_VALUE, l = temp.length;
		for (h = 0; h < l; h++)
			if (temp[h] >= max)
				max = temp[h];
		return max;
	}

	private static void show() {
		for (int i = 0; i < L.length; i++) {
			for (int j = 0; j < L.length; j++) {
				System.out.print(L[i][j] + " ");
			}
			System.out.println();
		}
	}
}
