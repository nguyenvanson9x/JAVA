package MatrixIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class InputMatrix {
	public InputMatrix() {

	}

	private static BufferedReader br;

	public int[][] readFile(String path) {
		int A[][] = new int[10][10];
		try {
			FileInputStream fi = new FileInputStream(path);
			br = new BufferedReader(new InputStreamReader(fi));
			String s;

			try {
				for (int i = 0; i < 10; i++) {
					s = br.readLine().trim();
					String B[] = s.split(" ");
					for (int j = 0; j < 10; j++) {
						A[i][j] = Integer.parseInt(B[j].trim());
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return A;

	}
}
