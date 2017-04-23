package revise;

public class ATM_Machine {
	private static int n, S;
	private static int[] x;
	private static int[] t = {10, 20, 30, 15, 25, 35, 100};

	public static void main(String[] args) {
		n = t.length;
		x = new int[n];
		S = 100;
		ATM(0);
	}
	/*
	 * ATM Machine
	 */
	private static void ATM(int i) {
		int j;
		for (j = 0; j <= 1; j++) {
			x[i] = j;
			if (i < n - 1)
				ATM(i + 1);
			else if (check())
				ket_qua();
		}
	}
	private static boolean check() {
		int i, sum = 0;
		for (i = 0; i < n; i++)
			sum += x[i] * t[i];
		if (sum == S)
			return true;
		return false;
	}
	private static void ket_qua() {
		int i;
		for (i = 0; i < n; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}
	

}
