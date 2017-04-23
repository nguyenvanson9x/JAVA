package Tuan06;

public class MatrixModel {
	private int[][] matrix = { 
			{ 1, 0, 1, 2, 3 }, 
			{ 1, 0, 1, 2, 3 },
			{ 1, 0, 1, 2, 3 }, 
			{ 1, 0, 1, 2, 3 }, 
			{ 1, 0, 1, 2, 3 } };
	
	public void subOne(){
		int length = matrix.length;
		
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				matrix[i][j]--;
			}
		}
	}
	
	public void addOne(){
	int length = matrix.length;
		
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				matrix[i][j]++;
			}
		}
	}
	
	public void updateCell(int i, int j){
		matrix[i][j]++;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}
}
