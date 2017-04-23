package matrix;

public class matrixRunner {
	public static void main(String[] args) {
		matrixModel model = new matrixModel();
		matrixView view = new matrixView(model);
		matrixController controller = new matrixController(view, model);
	}
}
