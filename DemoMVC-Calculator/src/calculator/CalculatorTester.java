package calculator;

public class CalculatorTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculatorModel model = new CalculatorModel();
		CalculatorView frame = new CalculatorView(model);
		CalculatorController controller = new CalculatorController(frame, model);
		frame.setVisible(true);
	}

}
