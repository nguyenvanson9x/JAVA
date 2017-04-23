package MatrixNumber;

public class Run {
	public static void main(String[] args) {
		MatrixNumberView theView = new MatrixNumberView();
		MatrixNumberModel theModel = new MatrixNumberModel();
		MatrixNumberController theController = new MatrixNumberController(theView, theModel);
	}
}
