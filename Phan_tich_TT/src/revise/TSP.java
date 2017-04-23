package revise;

public class TSP {
	private static int[] flag, x, xbest;
	private static int[][] c = { { 100, 2, 4, 6 }, { 2, 100, 7, 8 }, { 4, 7, 100, 3 }, { 6, 8, 3, 100 } };
	private static int n, c_min, sum, best;

	public static void main(String[] args) {
		n = c.length;
		sum = 0;
		best = Integer.MAX_VALUE;
		c_min = min(c);
		x = new int[n];
		flag = new int[n];
		xbest = new int[n];
		x[0] = 0;
		flag[0] = 1;
		tsp(1);
		ket_qua();
	}

	private static void tsp(int i) {
		if (sum + (n - i + 1) * c_min > best)
			return;
		else {
			int j;
			for (j = 0; j < n; j++)
				if (flag[j] == 0) {
					x[i] = j;
					flag[j] = 1;
					sum += c[x[i - 1]][j];
					if (i == n - 1)
						update();
					else
						tsp(i + 1);
					flag[j] = 0;
					sum -= c[x[i - 1]][j];
				}
		}
	}

	private static void update() {
		if (sum + c[x[n - 1]][0] < best) {
			best = sum + c[x[n - 1]][0];
			int i;
			for (i = 0; i < n; i++)
				xbest[i] = x[i];
		}
	}

	private static void ket_qua() {
		int i;
		for (i = 0; i < n; i++)
			System.out.print(xbest[i] + 1 +  " ");
	}

	private static int min(int[][] a) {
		int n = a.length, min = a[0][0], i, j;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				if (a[i][j] <= min && a[i][j] != 0)
					min = a[i][j];

		return min;
	}
}