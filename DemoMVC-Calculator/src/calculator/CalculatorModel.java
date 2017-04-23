package calculator;

public class CalculatorModel {
	private String[][] buttonNames = { { "Cls", "Bck", "", "Close" },
			{ "7", "8", "9", "/" }, { "4", "5", "6", "*" },
			{ "1", "2", "3", "-" }, { "0", ".", "=", "+" }, };

	public String[][] getButtonNames() {
		return buttonNames;
	}

	public String append(String current, String token) {
		String newResult;
		newResult = current + token;

		if (token.equals(".")) {
			if (current.contains(".")) {
				newResult = current;
			}
		}

		if (current.equals("0")) {
			if (token.equals("0") || token.equals("1") || token.equals("2")
					|| token.equals("3") || token.equals("4")
					|| token.equals("5") || token.equals("6")
					|| token.equals("7") || token.equals("8")
					|| token.equals("9")) {
				newResult = token;

			}
		}

		if (token.equals("Bck")) {
			if (current.length() > 0)
				newResult = current.substring(0, current.length() - 1);
			else
				newResult = current;
		}

		if (token.equals("Cls")) {
			newResult = "";
		}
		
		if(token.equals("Close")){
			System.exit(0);
		}

		return newResult;
	}
}
