package Calculator;

public class CalculatorRun {
	public static void main(String[] args) {
		
		CalculatorModel model = new CalculatorModel();
		CalculatorView view = new CalculatorView(model);
		CalculatorController controller = new CalculatorController(view, model);
	}
}
