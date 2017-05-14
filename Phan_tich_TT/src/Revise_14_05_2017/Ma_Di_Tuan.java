package Revise_14_05_2017;

public class Ma_Di_Tuan {
	private static int n;
	private static int[][] h;
	private static int[] a = { -2, -2, -1, -1, 1, 1, 2, 2 };
	private static int[] b = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) {
		n = 8;
		h = new int[2 * n][2 * n];
		hourse(0, 2, 2);
	}

	private static void hourse(int k, int x, int y) {
		int j;
		for (j = 0; j < n; j++) {
			if (x + a[j] >= 0 && x + a[j] < 8 && y + b[j] >= 0 && y + b[j] < 8 && h[x + a[j]][y + b[j]] == 0) {
				k++;
				x += a[j];
				y += b[j];
				h[x][y] = k;
				if (j == n * n - 1)
					ket_qua();
				else
					hourse(k, x, y);
				h[x][y] = 0;
				x -= a[j];
				y -= b[j];
				k--;
			}
		}
	}

	private static void ket_qua() {
		// TODO Auto-generated method stub
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(h[i][j] + " ");
			System.out.println();
		}
		
	}
}
