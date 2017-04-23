package matrix;

public class matrixModel {
	private int[][] matrix = { { 1, 0, 1, 2, 3 }, { 1, 0, 1, 2, 3 }, { 1, 0, 1, 2, 3 }, { 1, 0, 1, 2, 3 },
			{ 1, 0, 1, 2, 3 } };

	public void addOne() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j]++;
			}
		}

	}

	public void subOne() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j]--;
			}
		}
	}

	public void updateCell(int i, int j) {
		matrix[i][j]++;
	}

	public int[][] getMatrix() {
		return matrix;
	}
}
