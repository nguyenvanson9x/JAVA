package InToPos;

public class InfixToPosfix {
	
	/**
	 * Kiem tra do uu tien
	 * @param c Toan tu
	 * @return
	 */
	public int uuTien(char c) {
		if (c == '+' || c == '-')
			return 1;
		else if (c == '*' || c == '/')
			return 2;
		else
			return 0;

	}

	/**
	 * Kiem tra toan tu
	 * @param c Toan tu
	 * @return True neu 'c' la toan tu
	 */
	public boolean checkToanTu(char c) {
		switch (c) {
		case '+':
			return true;
		case '-':
			return true;
		case '*':
			return true;
		case '/':
			return true;
		default:
			return false;
		}
	}
	
	
}
