package Tuan06;

public class Runner {
	public static void main(String[] args) {
		
	MatrixModel model = new MatrixModel();
	MatrixView view = new MatrixView(); 
	MatrixController controller = new MatrixController(view, model);
	}
}
