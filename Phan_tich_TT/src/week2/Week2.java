package week2;

public class Week2 {

	// Bai_1
	/**
	 * Tìm số nhỏ nhất trong mảng
	 * 
	 * @param a
	 *            Mảng ban đầu
	 * @param l
	 *            Vị trí bắt đầu
	 * @param r
	 *            Vị trí kết thúc
	 * @return Trả về Min
	 */
	public static int min(int[] a, int l, int r) {
		if (l == r)
			return a[l];
		else {
			int m = l + (r - l) / 2;
			int min1, min2;

			min1 = min(a, l, m);
			min2 = min(a, m + 1, r);

			if (min1 < min2)
				return min1;
			else
				return min2;
		}
	}

	/**
	 * Tìm số lớn nhất trong mảng
	 * 
	 * @param a
	 *            Mảng ban đầu
	 * @param l
	 *            Vị trí bắt đầu
	 * @param r
	 *            Vị trí kết thúc
	 * @return Trả về Max
	 */
	public static int max(int[] a, int l, int r) {
		if (l == r)
			return a[l];
		
		else {
			int m = l + (r - l) / 2;
			int max1, max2;

			max1 = max(a, l, m);
			max2 = max(a, m + 1, r);

			if (max1 > max2)
				return max1;
			else
				return max2;
		}
	}

	// End Bai_1

	// Bai_2
	/**
	 * Sắp xếp mảng theo thuật toán QuickSort
	 * 
	 * @param a
	 *            Mảng ban đầu
	 * @param u
	 *            Vị trí bắt đầu
	 * @param v
	 *            Vị trí kết thúc
	 */
	public static void QuickSort(int[] a, int u, int v) {
		int i, j, m;
		i = u;
		j = v;
		m = a[u + (v - u) / 2];

		while (i <= j) {
			while (a[i] < m)
				i++;
			while (a[j] > m)
				j--;

			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		if (u < j)
			QuickSort(a, u, j);
		if (i < v)
			QuickSort(a, i, v);
	}

	/**
	 * Đổi vị trí hai phần tử trong mảng
	 * 
	 * @param a
	 *            Mảng ban đầu
	 * @param i
	 *            Phần thử thứ i trong mảng
	 * @param j
	 *            Phần thử thứ j trong mảng
	 */
	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	// End Bai_2

	// Bai_3
	/**
	 * Sắp xếp mảng theo thuật toán MergeSort
	 * 
	 * @param a
	 *            Mảng cần sắp xếp
	 */
	public static void MergeSort(int[] a) {
		int[] b = new int[a.length];
		mergeSort(a, b, 0, a.length - 1);
	}

	/**
	 * Sắp xếp một phần của mảng A
	 * 
	 * @param a
	 *            Mảng cần sắp xếp
	 * @param b
	 *            Mảng đệm
	 * @param u
	 *            Vị trí bắt đầu
	 * @param v
	 *            Vị trí kết thúc
	 */
	private static void mergeSort(int[] a, int[] b, int u, int v) {
		if (u < v) {
			int m = u + (v - u) / 2;

			mergeSort(a, b, u, m);
			mergeSort(a, b, m + 1, v);
			merge(a, b, u, m, v);
		}
	}

	/**
	 * Trộn các phần của mảng A sau khi sắp xếp
	 * 
	 * @param a
	 *            Mảng cần sắp xếp
	 * @param b
	 *            Mảng đệm
	 * @param u
	 *            Vị trí bắt đầu
	 * @param m
	 *            Vị trí chính giữa
	 * @param v
	 *            Vị trí kết thúc
	 */
	private static void merge(int[] a, int[] b, int u, int m, int v) {
		for (int k = u; k <= v; k++)
			b[k] = a[k];

		int i = u;
		int j = m + 1;

		for (int k = u; k <= v; k++) {
			if (i > m)
				a[k] = b[j++];
			else if (j > v)
				a[k] = b[i++];
			else if (b[j] < b[i])
				a[k] = b[j++];
			else
				a[k] = b[i++];
		}

	}
	// End Bai_3

	// Bai_4
	/**
	 * Nhân hai ma trận A, B
	 * 
	 * @param A
	 *            Ma trận thứ nhất
	 * @param B
	 *            Ma trận thứ 2
	 * @return Tích hai ma trận
	 */
	public static int[][] matrixMultiplication(int[][] A, int[][] B) {
		int n = A.length;
		int[][] R = new int[n][n];

		if (n == 1)
			R[0][0] = A[0][0] * B[0][0];
		else {
			int[][] A11 = new int[n / 2][n / 2];
			int[][] A12 = new int[n / 2][n / 2];
			int[][] A21 = new int[n / 2][n / 2];
			int[][] A22 = new int[n / 2][n / 2];
			int[][] B11 = new int[n / 2][n / 2];
			int[][] B12 = new int[n / 2][n / 2];
			int[][] B21 = new int[n / 2][n / 2];
			int[][] B22 = new int[n / 2][n / 2];

			cutMatrix(A, A11, 0, 0);
			cutMatrix(A, A12, 0, n / 2);
			cutMatrix(A, A21, n / 2, 0);
			cutMatrix(A, A22, n / 2, n / 2);

			cutMatrix(B, B11, 0, 0);
			cutMatrix(B, B12, 0, n / 2);
			cutMatrix(B, B21, n / 2, 0);
			cutMatrix(B, B22, n / 2, n / 2);

			int[][] C11 = congMatrix(matrixMultiplication(A11, B11), matrixMultiplication(A12, B12));
			int[][] C12 = congMatrix(matrixMultiplication(A11, B12), matrixMultiplication(A12, B22));
			int[][] C21 = congMatrix(matrixMultiplication(A21, B11), matrixMultiplication(A22, B21));
			int[][] C22 = congMatrix(matrixMultiplication(A21, B12), matrixMultiplication(A22, B22));

			hopMatrix(C11, R, 0, 0);
			hopMatrix(C12, R, 0, n / 2);
			hopMatrix(C21, R, n / 2, 0);
			hopMatrix(C22, R, n / 2, n / 2);
		}
		return R;
	}

	/**
	 * Tách ma trận ban đầu thành ma trận con
	 * 
	 * @param s
	 *            Ma trận ban đầu
	 * @param des
	 *            Ma trận kết quả
	 * @param rowStart
	 *            Vị trí cột bắt đầu cắt
	 * @param colStart
	 *            Vị trí hàng bắt đầu cắt
	 */
	private static void cutMatrix(int[][] s, int[][] des, int rowStart, int colStart) {
		int size = des[0].length;
		int i, j;
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				des[i][j] = s[i + rowStart][j + colStart];
			}
		}
	}

	/**
	 * Cộng hai ma trận
	 * 
	 * @param A
	 *            Ma trận thứ nhất
	 * @param B
	 *            Ma trận thứ hai
	 * @return Tổng hai ma trận
	 */
	private static int[][] congMatrix(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				C[i][j] = A[i][j] + B[i][j];
		return C;
	}

	/**
	 * Hợp ma trận con vào ma trận cha
	 * 
	 * @param C
	 *            Ma trận con
	 * @param R
	 *            Ma trận cha
	 * @param rowStart
	 *            Vị trí hàng
	 * @param ColStart
	 *            Vị trí cột
	 */
	private static void hopMatrix(int[][] C, int[][] R, int rowStart, int ColStart) {
		int size = C[0].length;
		int i, j;
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				R[i + rowStart][j + ColStart] = C[i][j];
			}
		}
	}

	// End Bai_4

	// Bai_5
	private static int number = 0;
	private static int[][] Tile;

	/**
	 * Lat nền
	 * 
	 * @param rowStart
	 *            Ví trí dòng bắt đầu lát
	 * @param colStart
	 *            Vị trí cột bắt đầu lát
	 * @param size
	 *            Kích cỡ của nền
	 * @param x
	 *            Tọa độ x của lỗ thoát nước
	 * @param y
	 *            Tọa độ y của lỗ thoát nước
	 */
	public static void Tile(int rowStart, int colStart, int size, int x, int y) {
		int vitri, g;
		number++;
		if (size == 2)
			Tile2(rowStart, colStart, x, y);
		else {
			vitri = vitri(rowStart, colStart, size, x, y);
			g = size / 2;
			switch (vitri) {
			case 1:
				Tile[rowStart + g - 1][colStart + g] = number;
				Tile[rowStart + g][colStart + g] = number;
				Tile[rowStart + g][colStart + g - 1] = number;

				Tile(rowStart, colStart, g, x, y);
				Tile(rowStart, colStart + g, g, rowStart + g - 1, colStart + g);
				Tile(rowStart + g, colStart + g, g, rowStart + g, colStart + g);
				Tile(rowStart + g, colStart, g, rowStart + g, colStart + g - 1);
				break;
			case 2:
				Tile[rowStart + g - 1][colStart + g - 1] = number;
				Tile[rowStart + g - 1][colStart + g] = number;
				Tile[rowStart + g][colStart + g] = number;

				Tile(rowStart, colStart, g, rowStart + g - 1, colStart + g - 1);
				Tile(rowStart, colStart + g, g, rowStart + g - 1, colStart + g);
				Tile(rowStart + g, colStart + g, g, rowStart + g, colStart + g);
				Tile(rowStart + g, colStart, g, x, y);
				break;
			case 3:
				Tile[rowStart + g - 1][colStart + g - 1] = number;
				Tile[rowStart + g - 1][colStart + g] = number;
				Tile[rowStart + g][colStart + g - 1] = number;

				Tile(rowStart, colStart, g, rowStart + g - 1, colStart + g - 1);
				Tile(rowStart, colStart + g, g, rowStart + g - 1, colStart + g);
				Tile(rowStart + g, colStart + g, g, x, y);
				Tile(rowStart + g, colStart, g, rowStart + g, colStart + g - 1);
				break;
			case 4:
				Tile[rowStart + g - 1][colStart + g - 1] = number;
				Tile[rowStart + g][colStart + g] = number;
				Tile[rowStart + g][colStart + g - 1] = number;

				Tile(rowStart, colStart, g, rowStart + g - 1, colStart + g - 1);
				Tile(rowStart, colStart + g, g, x, y);
				Tile(rowStart + g, colStart + g, g, rowStart + g, colStart + g);
				Tile(rowStart + g, colStart, g, rowStart + g, colStart + g - 1);
				break;
			default:
				break;
			}
		}

	}

	/**
	 * Góc phần tư chưa lỗ thoát nước
	 * 
	 * @param rowStart
	 *            Vị trí dòng
	 * @param colStart
	 *            Vị trí cột
	 * @param size
	 *            Kích cỡ của nền
	 * @param x
	 *            Tọa độ x của lỗ thoát
	 * @param y
	 *            Tọa độ y của lỗ thoát
	 * @return Góc phần tư chứa lỗ thoát
	 */
	private static int vitri(int rowStart, int colStart, int size, int x, int y) {
		int vitri, g;
		g = size / 2;
		if ((x >= rowStart) && (x < rowStart + g)) {
			if (y < colStart + g)
				vitri = 1;
			else
				vitri = 4;
		} else if (y < colStart + g)
			vitri = 2;
		else
			vitri = 3;
		return vitri;
	}

	/**
	 * Đặt 1 viên gạch vào chính giữa nền
	 * 
	 * @param rowStart
	 *            Vị trí dòng bắt đầu
	 * @param colStart
	 *            Vị trí cột bắt đầu
	 * @param x
	 *            Tọa độ x của lỗ thoát
	 * @param y
	 *            Tọa độ y của lỗ thoát
	 */
	private static void Tile2(int rowStart, int colStart, int x, int y) {
		int vitri = vitri(rowStart, colStart, 2, x, y);
		switch (vitri) {
		case 1:
			Tile[rowStart][colStart + 1] = number;
			Tile[rowStart + 1][colStart + 1] = number;
			Tile[rowStart + 1][colStart] = number;
			break;
		case 2:
			Tile[rowStart][colStart] = number;
			Tile[rowStart][colStart + 1] = number;
			Tile[rowStart + 1][colStart + 1] = number;
			break;
		case 3:
			Tile[rowStart][colStart] = number;
			Tile[rowStart][colStart + 1] = number;
			Tile[rowStart + 1][colStart] = number;
			break;
		case 4:
			Tile[rowStart][colStart] = number;
			Tile[rowStart + 1][colStart] = number;
			Tile[rowStart + 1][colStart + 1] = number;
			break;
		default:
			break;
		}
	}
	// End Bai_5

	// Main
	public static void main(String[] args) {

		// Excute Bai_1
		System.out.println("Bai 1:");
		int[] a = { 1, 3, 4, 5, 6, 7, 5, 10, 2, 4, 11, 4 };
		System.out.println("Min: " + min(a, 0, a.length - 1));
		System.out.println("Max: " + max(a, 0, a.length - 1));

		// Excute Bai_2
		System.out.println("Bai 2: QuickSort");
		int[] b = a;
		QuickSort(b, 0, b.length - 1);
		for (int i : b)
			System.out.print(i + " ");
		System.out.println();

		// Excute Bai_3
		System.out.println("Bai 3: MergeSort");
		int[] c = a;
		MergeSort(c);
		for (int i : c)
			System.out.print(i + " ");
		System.out.println();

		// Excute Bai_4
		System.out.println("Bai 4: Nhan ma tran");
		int[][] X = { { 1, 0 }, { 0, 1 } };
		int[][] Y = { { 3, 5 }, { 5, 6 } };
		int[][] R = matrixMultiplication(X, Y);

		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R.length; j++)
				System.out.print(R[i][j] + " ");
			System.out.println();
		}

		// Excute Bai_5
		System.out.println("Bai 5: Lat nen");
		int n = 3;
		int size = (int) Math.pow(2, n);
		Tile = new int[size][size];
		Tile(0, 0, size, 7, 6);

		for (int i = 0; i < Tile.length; i++) {
			for (int j = 0; j < Tile.length; j++)
				System.out.print(Tile[i][j] + "\t");
			System.out.println();
		}

	}
}
