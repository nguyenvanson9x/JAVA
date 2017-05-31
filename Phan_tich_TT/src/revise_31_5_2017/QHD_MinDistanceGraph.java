package revise_31_5_2017;

import java.util.Stack;

public class QHD_MinDistanceGraph {
	private static Stack<Integer> s;
	private static int n, a = Integer.MAX_VALUE / 100;
	private static int[][] d, p;
	private static int[][] c = { { 0, 5, a, a }, { 50, 0, 15, 5 }, { 30, a, 0, a }, { 15, a, 5, 0 } };

	public static void main(String[] args) {
		s = new Stack<>();
		n = c.length;
		d = new int[n][n];
		p = new int[n][n];
		clone(c, d);
		MinDistanceGraph(0, 3);
	}

	public static void MinDistanceGraph(int from, int to) {
		int i, j, k;
		for (k = 0; k < n; k++)
			for (i = 0; i < n; i++)
				for (j = 0; j < n; j++)
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
						p[i][j] = k;
					}

		// Show path
		i = from;
		j = to;
		while (p[i][j] != 0) {
			s.push(p[i][j]);
			j = p[i][j];
		}
		System.out.print(from + " ");
		for (int item : s)
			System.out.print(item + " ");
		System.out.print(to);
	}

	private static void clone(int[][] src, int[][] des) {
		int i, j, l = src.length;
		for (i = 0; i < l; i++)
			for (j = 0; j < l; j++)
				des[i][j] = src[i][j];
	}
}
