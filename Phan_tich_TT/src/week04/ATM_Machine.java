package week04;

public class ATM_Machine {
	private static int[] x;
	private static int[] t = {100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000};
	private static int n, S;

	public static void main(String[] args) {
		S = 80000;
		n = t.length;
		
		x = new int[n];
		ATM(0);
	}

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

	private static void ket_qua() {
		// TODO Auto-generated method stub
		int i;
		for (i = 0; i < n; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();

	}

	private static boolean check() {
		// TODO Auto-generated method stub
		int i, sum = 0;
		;
		for (i = 0; i < n; i++) {
			sum += x[i] * t[i];
		}
		if (sum == S)
			return true;
		return false;
	}
}
