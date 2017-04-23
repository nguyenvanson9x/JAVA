package matrix;

public class MatrixNumber {
	public static int[][] matrix = { { 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 }, { 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 },
			{ 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 }, { 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 },
			{ 1, 0, 0, 1, 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 1, 0, 1, 0 } };

	private static int[][] creatMarkMatrix(int[][] m) {
		int l = matrix.length;
		int markMatrix[][] = new int[l + 2][l + 2];
		for (int i = 0; i < markMatrix.length; i++) {
			for (int j = 0; j < markMatrix.length; j++) {
				markMatrix[i][j] = 0;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				markMatrix[i + 1][j + 1] = matrix[i][j];
			}
		}
		
	return markMatrix;
	}
	
	private static int[][] sumMatrix(int[][] m){
		int sumM[][] = new int[matrix.length][matrix.length];
		
		for (int i = 0; i < sumM.length; i++) {
			for (int j = 0; j < sumM.length; j++) {
				sumM[i][j] = sum(i+1, j+1, m);
			}
		}
		return sumM;
	}
	
	private static int sum(int a, int b, int[][]m) {
		int sum;
		int s = 0;
		for (int i = a-1; i < a+2; i++) {
			for (int j = b-1; j < b+2; j++) {
				s+=m[i][j];
			}
		}
		sum = s-m[a][b];
		
		return sum;
	}
	public static int[][] standardizedMatrix(int[][] matrixNew) {
		
		int length = matrixNew.length;
		int temp[][] = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (matrixNew[i][j]==3 | matrixNew[i][j]==2) {
					temp[i][j]=1;
				} else
					temp[i][j]=0;
					
			}

		}
		return temp;
	}
	 

	public static void main(String[] args) {

		int newmatrix[][] = creatMarkMatrix(matrix);
		int sumMatrix[][] = sumMatrix(newmatrix);
		int chuanhoa[][] = standardizedMatrix(sumMatrix);
		for (int i = 0; i < chuanhoa.length;i ++) {
			for (int j = 0; j < chuanhoa.length; j++) {
				System.out.print(chuanhoa[i][j]+" ");
			}
			System.out.print("\n");
		}
		
//		int chuanhoa[][] = standardizedMatrix(sumMatrix);
//		int M[][] = creatMarkMatrix(chuanhoa);
//		int demo[][] = sumMatrix(M);
//		for (int i = 0; i < demo.length;i ++) {
//			for (int j = 0; j < demo.length; j++) {
//				System.out.print(demo[i][j]+" ");
//			}
//			System.out.print("\n");
//		}
	}
}
