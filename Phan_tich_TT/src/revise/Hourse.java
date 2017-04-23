package revise;

public class Hourse {
	private static int[] a = { -2, -2, -1, -1, 1, 1, 2, 2 };
	private static int[] b = { -1, 1, -2, 2, -2, 2, -1, 1 };
	private static int[][] h;
	private static int n;

	public static void main(String[] args) {
		n = 8;
		h = new int[n][n];
		int i, j;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				h[i][j] = 0;
		hourse(2, 2, 0);
	}

	private static void hourse(int x, int y, int i) {
		int j;
		for (j = 0; j < 8; j++)
			if (x + a[j] >= 0 && x + a[j] < n && y + b[j] >= 0 && y + b[j] < n && h[x + a[j]][y + b[j]] == 0) {
				x += a[j];
				y += b[j];
				h[x][y] = i + 1;
				if (i < n * n)
					hourse(x, y, i + 1);
				else
					ket_qua();
				h[x][y] = 0;
				x -= a[j];
				y -= b[j];

			}

	}

	private static void ket_qua() {
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(h[i][j] + " ");
			System.out.println();
		}
	}

}
