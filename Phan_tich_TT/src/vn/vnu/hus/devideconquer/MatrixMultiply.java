package vn.vnu.hus.devideconquer;

import java.util.Random;

public class MatrixMultiply {
	// lay ra mot phan cua ma tran
	public static void copySubMatrix(int[][] sourceMatrix, int[][] destinationMatrix, int startRow, int startCol) {

		for (int i = 0; i < destinationMatrix.length; i++) {

			for (int j = 0; j < destinationMatrix.length; j++) {

				destinationMatrix[i][j] = sourceMatrix[i + startRow][j + startCol];
			}
		}
	}

	// cong hai ma tran
	public static int[][] plus(int[][] matrixA, int[][] matrixB) {

		int result[][] = new int[matrixA.length][matrixA.length];

		for (int i = 0; i < matrixA.length; i++) {

			for (int j = 0; j < matrixA.length; j++) {

				result[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}
		return result;
	}
	// tru hai ma tran
	public static int[][] subtract(int[][] a, int[][] b) {

		int result[][] = new int[a.length][a.length];

		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < a.length; j++) {

				result[i][j] = a[i][j] - b[i][j];
			}
		}
		return result;
	}
	// copy toan bo ma tran source vao ma tran destination
	public static void copyWholeMatrix(int[][] sourceMatrix, int[][] destinationMatrix, int startRow, int startCol) {
		
		for (int i = 0; i < sourceMatrix.length; i++) {

			for (int j = 0; j < sourceMatrix.length; j++) {
		
				destinationMatrix[i + startRow][j + startCol] = sourceMatrix[i][j];
			}
		}
	}
	// thuat toan nhan thong thuong
	public static int[][] multiply(int[][] a, int[][] b) {
		
		final int n = a.length;
		final int[][] c = new int[n][n];
		if (n == 1) {
			
			c[0][0] = a[0][0] * b[0][0];
		} else {
			
			int[][] a11 = new int[n / 2][n / 2];
			int[][] a12 = new int[n / 2][n / 2];
			int[][] a21 = new int[n / 2][n / 2];
			int[][] a22 = new int[n / 2][n / 2];
			int[][] b11 = new int[n / 2][n / 2];
			int[][] b12 = new int[n / 2][n / 2];
			int[][] b21 = new int[n / 2][n / 2];
			int[][] b22 = new int[n / 2][n / 2];

			copySubMatrix(a, a11, 0, 0);
			copySubMatrix(a, a12, 0, n / 2);
			copySubMatrix(a, a21, n / 2, 0);
			copySubMatrix(a, a22, n / 2, n / 2);
			copySubMatrix(b, b11, 0, 0);
			copySubMatrix(b, b12, 0, n / 2);
			copySubMatrix(b, b21, n / 2, 0);
			copySubMatrix(b, b22, n / 2, n / 2);

			int[][] c11 = plus(multiply(a11, b11), multiply(a12, b21));
			int[][] c12 = plus(multiply(a11, b12), multiply(a12, b22));
			int[][] c21 = plus(multiply(a21, b11), multiply(a22, b21));
			int[][] c22 = plus(multiply(a21, b12), multiply(a22, b22));
			
			copyWholeMatrix(c11, c, 0, 0);
			copyWholeMatrix(c12, c, 0, n / 2);
			copyWholeMatrix(c21, c, n / 2, 0);
			copyWholeMatrix(c22, c, n / 2, n / 2);
		}
		
		return c;
	}
	// thuat toan strassen
	public static int[][] strassen(int[][] a, int[][] b) {
	
		int n = a.length;
		int[][] c = new int[n][n];
		if (n == 1) {
			c[0][0] = a[0][0] * b[0][0];
		} else {
			int[][] a11 = new int[n / 2][n / 2];
			int[][] a12 = new int[n / 2][n / 2];
			int[][] a21 = new int[n / 2][n / 2];
			int[][] a22 = new int[n / 2][n / 2];
			int[][] b11 = new int[n / 2][n / 2];
			int[][] b12 = new int[n / 2][n / 2];
			int[][] b21 = new int[n / 2][n / 2];
			int[][] b22 = new int[n / 2][n / 2];

			copySubMatrix(a, a11, 0, 0);
			copySubMatrix(a, a12, 0, n / 2);
			copySubMatrix(a, a21, n / 2, 0);
			copySubMatrix(a, a22, n / 2, n / 2);
			copySubMatrix(b, b11, 0, 0);
			copySubMatrix(b, b12, 0, n / 2);
			copySubMatrix(b, b21, n / 2, 0);
			copySubMatrix(b, b22, n / 2, n / 2);

			int[][] m1 = strassen(plus(a11, a22), plus(b11, b22));
			int[][] m2 = strassen(plus(a21, a22), b11);
			int[][] m3 = strassen(a11, subtract(b12, b22));
			int[][] m4 = strassen(a22, subtract(b21, b11));
			int[][] m5 = strassen(plus(a11, a12), b22);
			int[][] m6 = strassen(subtract(a21, a11), plus(b11, b12));
			int[][] m7 = strassen(subtract(a12, a22), plus(b21, b22));

			int[][] c11 = plus(subtract(plus(m1, m4), m5), m7);
			int[][] c12 = plus(m3, m5);
			int[][] c21 = plus(m2, m4);
			int[][] c22 = plus(subtract(plus(m1, m3), m2), m6);

			copyWholeMatrix(c11, c, 0, 0);
			copyWholeMatrix(c12, c, 0, n / 2);
			copyWholeMatrix(c21, c, n / 2, 0);
			copyWholeMatrix(c22, c, n / 2, n / 2);
		}
		return c;
	}
	
	public static void printArray(int matrix[][]) {

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix.length; j++) {

				System.out.print(matrix[i][j] + " \t");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		int n = 4;
		Random r = new Random();
		int[][] a = new int[n][n];
		int[][] b = new int[n][n];
		int[][] c = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = r.nextInt(3);
				b[i][j] = r.nextInt(3);
			}
		}
		System.out.println("Nhan 2 ma tran thong thuong");
		c = multiply(a, b);
		printArray(c);
		System.out.println("Nhan hai ma tran su dung thuat toan Strassen");
		c = strassen(a, b);
		printArray(c);
	}

}
