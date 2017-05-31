package Revise_14_05_2017;

public class ATM {
	private static int n, S, sum;
	private static int[] x, t = { 100, 50, 50, 200, 100};

	public static void main(String[] args) {
		n = t.length;
		x = new int[n];
		S = 200;
		sum = 0;
		ATM_Machine(0);
	}

	private static void ATM_Machine(int i) {
		int j;
		for (j = 0; j <= 1; j++) {
			x[i] = j;
			sum += x[i] * t[i];
			if (i < n - 1)
				ATM_Machine(i + 1);
			else if (sum == S)
				ket_qua();
			sum -= x[i] * t[i];
		}
		
	}
	private static boolean check() {
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
