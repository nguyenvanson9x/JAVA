package MatrixNumber;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MatrixNumberModel {
	public int[][] matrix = { { 1, 0, 1, 2, 3 }, { 1, 0, 1, 2, 3 },
			{ 1, 0, 1, 2, 3 }, { 1, 0, 1, 2, 3 }, { 1, 0, 1, 2, 3 } };

	public JButton[][] groundButton;

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int length() {
		return matrix.length;
	}

	public int[][] updateMatrixByAdd() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j]++;
			}
		}
		return matrix;
	}

	public int[][] updateMatrixBySub() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j]--;
			}
		}
		return matrix;
	}

	public void updateCell(int i, int j) {
		matrix[i][j]++;
	}

	public void updateAllButtons(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				groundButton[i][j].setText(matrix[i][j] + "");

			}
		}
	}
}
