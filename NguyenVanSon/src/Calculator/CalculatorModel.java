package Calculator;

public class CalculatorModel {
	private String[][] strButton = { { "7", "8", "9", "/" }, { "4", "5", "6", "*" }, { "1", "2", "3", "-" },
			{ "0", ".", "=", "+" }};

	public String[][] getStrButton() {
		return strButton;
	}

	public String append(String currentText, String token) {
		String newResult = null;
		newResult = currentText + token;

		if (token.equals(".")) {
			if (currentText.contains(".")) {
				newResult = currentText;
			}
		}

		if (currentText.equals("0")) {
			if (token.equals("0") || token.equals("1") || token.equals("2") || token.equals("3") || token.equals("4")
					|| token.equals("5") || token.equals("6") || token.equals("7") || token.equals("8")
					|| token.equals("9")) {
				newResult = token;

			}
		}
		return newResult;
	}

}
