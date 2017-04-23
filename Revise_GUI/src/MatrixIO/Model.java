package MatrixIO;

public class Model {
	private int[][] matrix 
//	= { { 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 },
//			{ 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 }, { 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
//			{ 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 }, { 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 },
//			{ 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 } }
	;

	public Model() {

	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int[][] creatMarkMatrix(int[][] m) {
		int l = m.length;
		int markMatrix[][] = new int[l + 2][l + 2];
		for (int i = 0; i < markMatrix.length; i++) {
			for (int j = 0; j < markMatrix.length; j++) {
				markMatrix[i][j] = 0;
			}
		}

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				markMatrix[i + 1][j + 1] = m[i][j];
			}
		}

		return markMatrix;
	}

	private int sum(int a, int b, int[][] m) {
		int sum;
		int s = 0;
		for (int i = a - 1; i < a + 2; i++) {
			for (int j = b - 1; j < b + 2; j++) {
				s += m[i][j];
			}
		}
		sum = s - m[a][b];

		return sum;
	}

	public int[][] sumMatrix(int[][] m) {
		int l = matrix.length;
		int sumM[][] = new int[l][l];
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				sumM[i][j] = sum(i + 1, j + 1, m);
			}
		}
		return sumM;
	}

	public void standardizedMatrix(int[][] matrixNew) {

		int length = matrix.length;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (matrixNew[i][j] == 3 | matrixNew[i][j] == 2) {
					matrix[i][j] = 1;
				} else
					matrix[i][j] = 0;

			}

		}
	}

}
