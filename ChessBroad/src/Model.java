import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Model {
	private int[][] numbers;
	private Scanner scan;
	private FileInputStream fis;

	public int getSize() {
		return numbers.length;
	}

	public int[][] getNumber() {
		return numbers;
	}

	public int[][] inputMatrix(String path) {
		try {
			fis = new FileInputStream(path);
			scan = new Scanner(fis);
			int n = scan.nextInt();
			numbers = new int[n][n];
			while (scan.hasNext()) {
				for (int i = 0; i < numbers.length; i++) {
					for (int j = 0; j < numbers.length; j++) {
						numbers[i][j] = scan.nextInt();
					}
				}
			}
			scan.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return numbers;
	}

	public void UP() {
		// TODO Auto-generated method stub
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {

				if (numbers[i][j] == 1) {
					int k = i;
					numbers[i][j] = 0;
					while (k > 0 && numbers[k - 1][j] == 0) {
						k--;
					}
					numbers[k][j] = 1;
				}
			}
		}

	}

	public void DOWN() {
		// TODO Auto-generated method stub
		for (int i = numbers.length - 1; i >= 0; i--) {
			for (int j = numbers.length - 1; j >= 0; j--) {
				if (numbers[i][j] == 1) {
					int k = i;
					numbers[i][j] = 0;
					while (k < (numbers.length - 1) && numbers[k + 1][j] == 0) {
						k++;
					}
					numbers[k][j] = 1;
				}
			}
		}

	}

	public void LEGHT() {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i][j] == 1) {
					int k = j;
					numbers[i][k] = 0;
					while (k > 0 && numbers[i][k - 1] == 0) {
						k--;
					}
					numbers[i][k] = 1;
				}
			}
		}

	}

	public void RIGHT() {
		for (int i = numbers.length - 1; i >= 0; i--) {
			for (int j = numbers.length - 1; j >= 0; j--) {
				if (numbers[i][j] == 1) {
					int k = j;
					numbers[i][k] = 0;
					while (k < numbers.length - 1 && numbers[i][k + 1] == 0) {
						k++;
					}
					numbers[i][k] = 1;
				}
			}
		}

	}
}
