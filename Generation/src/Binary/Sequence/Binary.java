package Binary.Sequence;

public class Binary {

	public static void fillChar(char[] x, int start, char value) {
		for (int i = start; i < x.length; i++) {
			x[i] = value;
		}

	}

	public static void plusBinary(char[] x) {
		int i;
		i = x.length;
		while (i > 0 && x[i - 1] == '1') {
			i--;
		}
		if (i > 0) {
			x[i - 1] = '1';
			fillChar(x, i, '0');
		}
	}

	public static void binary(int n) {
		char[] x = new char[n];
		fillChar(x, 0, '0');

//		char[] y = new char[n];
//		fillChar(y, 0, '0');

		for (int i = 0; i < Math.pow(2, n); i++) {
			System.out.println(x);
			plusBinary(x);
		}

	}

	public static void main(String[] args) {
		binary(4);
	}
}
