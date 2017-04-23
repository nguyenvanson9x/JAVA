package week2;

public class Matrix {

	public static void main(String[] args) {

		int a[][] = { { 1, 2, 3, 4 }, { 4, 5, 1, 2 }, { 1, 2, 0, 2 }, { 1, 2, 5, 2 } };
		int b[][] = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, {0, 0, 0, 1 } };

		int c[][] = { { 1 } };
		int d[][] = { { 2 } };

		int[][] s = strassen(a, b, a.length);
		int t[][] = matrixMultiPlication(a, b, a.length);

		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				System.out.print(s[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();

		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t.length; j++) {
				System.out.print(t[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static int[][] matrixMultiPlication(int a[][], int b[][], int n) {
		int c[][] = new int[n][n];
		if (n == 1) {
			c[0][0] = a[0][0] * b[0][0];
			return c;
		} else {
			int a11[][] = copyToPartMatrix(a, 0, 0);
			int a12[][] = copyToPartMatrix(a, 0, n / 2);
			int a21[][] = copyToPartMatrix(a, n / 2, 0);
			int a22[][] = copyToPartMatrix(a, n / 2, n / 2);

			int b11[][] = copyToPartMatrix(b, 0, 0);
			int b12[][] = copyToPartMatrix(b, 0, n / 2);
			int b21[][] = copyToPartMatrix(b, n / 2, 0);
			int b22[][] = copyToPartMatrix(b, n / 2, n / 2);

			int x1[][] = matrixMultiPlication(a11, b11, n / 2);
			int x2[][] = matrixMultiPlication(a11, b12, n / 2);
			int x3[][] = matrixMultiPlication(a12, b21, n / 2);
			int x4[][] = matrixMultiPlication(a12, b22, n / 2);
			int x5[][] = matrixMultiPlication(a21, b11, n / 2);
			int x6[][] = matrixMultiPlication(a21, b12, n / 2);
			int x7[][] = matrixMultiPlication(a22, b21, n / 2);
			int x8[][] = matrixMultiPlication(a22, b22, n / 2);

			int c11[][] = addTwoMatrix(x1, x3);
			int c12[][] = addTwoMatrix(x2, x4);
			int c21[][] = addTwoMatrix(x5, x7);
			int c22[][] = addTwoMatrix(x6, x8);
			
			c = copyToAllMatrix(c11, c12, c21, c22);
		}
		return c;
	}

	public static int[][] strassen(int[][] a, int[][] b, int n) {
		int c[][] = new int[n][n];
		if (n == 1) {
			c[0][0] = a[0][0] * b[0][0];
			//return c;
		} else {
			int a11[][] = copyToPartMatrix(a, 0, 0);
			int a12[][] = copyToPartMatrix(a, 0, n / 2);
			int a21[][] = copyToPartMatrix(a, n / 2, 0);
			int a22[][] = copyToPartMatrix(a, n / 2, n / 2);

			int b11[][] = copyToPartMatrix(b, 0, 0);
			int b12[][] = copyToPartMatrix(b, 0, n / 2);
			int b21[][] = copyToPartMatrix(b, n / 2, 0);
			int b22[][] = copyToPartMatrix(b, n / 2, n / 2);

			int p1[][] = strassen(a11, subTwoMatrix(b12, b22), n / 2);
			int p2[][] = strassen(addTwoMatrix(a11, a12), b22, n / 2);
			int p3[][] = strassen(addTwoMatrix(a21, a22), b11, n / 2);
			int p4[][] = strassen(a22, subTwoMatrix(b21, b11), n / 2);
			int p5[][] = strassen(addTwoMatrix(a11, a22), addTwoMatrix(b11, b22), n / 2);
			int p6[][] = strassen(subTwoMatrix(a12, a22), addTwoMatrix(b21, b22), n / 2);
			int p7[][] = strassen(subTwoMatrix(a11, a21), addTwoMatrix(b11, b12), n / 2);

			int c11[][] = addTwoMatrix(subTwoMatrix(addTwoMatrix(p5, p4), p2), p6);
			int c12[][] = addTwoMatrix(p1, p2);
			int c21[][] = addTwoMatrix(p3, p4);
			int c22[][] = subTwoMatrix(subTwoMatrix(addTwoMatrix(p1, p5), p3), p7); // p1 - p3 + p5 + p7. 
			c = copyToAllMatrix(c11, c12, c21, c22);
		}
		return c;
	}

	public static int[][] copyToPartMatrix(int s[][], int row, int col) {
		int part[][] = new int[s.length / 2][s.length / 2];
		for (int i = 0; i < part.length; i++) {
			for (int j = 0; j < part.length; j++) {
				part[i][j] = s[row + i][col + j];
			}
		}
		return part;
	}

	public static int[][] copyToAllMatrix(int a[][], int b[][], int c[][], int d[][]) {
		int s[][] = new int[a.length * 2][a.length * 2];
		int n = s.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				s[i][j] = a[i][j];
				s[0 + i][n / 2 + j] = b[i][j];
				s[n / 2 + i][0 + j] = c[i][j];
				s[n / 2 + i][n / 2 + j] = d[i][j];
			}
		}

		return s;
	}

	public static int[][] addTwoMatrix(int a[][], int b[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = a[i][j] + b[i][j];
			}
		}
		return a;
	}

	public static int[][] subTwoMatrix(int a[][], int b[][]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = a[i][j] - b[i][j];
			}
		}
		return a;
	}

}
