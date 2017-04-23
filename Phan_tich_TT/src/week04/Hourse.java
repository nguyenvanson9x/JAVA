package week04;

public class Hourse {
	private static int a[] = { -2, -2, -1, 1, 2, 2, 1, -1 };
	private static int b[] = { -1, 1, 2, 2, 1, -1, -2, -2 };
	private static int h[][];
	private static int n;

	private static void Ngua(int x, int y, int k) {
		for (int i = 0; i < n; i++) {
			if ((x + a[i]) >= 0 && (x + a[i]) < n && (y + b[i]) >= 0
					&& (y + b[i]) < n && h[x + a[i]][y + b[i]] == 0) {
				x = x + a[i];
				y = y + b[i];
				k++;
				h[x][y] = k;

				if (k <= n * n - 1)
					Ngua(x, y, k);
				else
					ket_qua();

				h[x][y] = 0;
				k--;
				x = x - a[i];
				y = y - b[i];
			}
		}
	}

	private static void ket_qua() {
		// TODO Auto-generated method stub
		for (int i = 0; i < h[0].length; i++) {
			for (int j = 0; j < h[0].length; j++) {
				System.out.print(h[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("-------------------");

	}

	public static void main(String[] args) {
		n = 8;
		h = new int[n][n];
		for (int i = 0; i < h[0].length; i++) {
			for (int j = 0; j < h[0].length; j++) {
				h[i][j] = 0;
			}
		}
		Ngua(2, 2, 0);
	}
}
