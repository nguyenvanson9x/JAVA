package Revise_14_05_2017;

public class Binary {
	private static int n;
	private static int[] x;

	public static void main(String[] args) {
		n = 4;
		x = new int[n];
		Bin(0);
	}

	private static void Bin(int i) {
		int j;
		for (j = 0; j <= 1; j++) {
			x[i] = j;
			if (i == n - 1)
				ket_qua();
			else
				Bin(i + 1);
		}
	}

	private static void ket_qua() {
		int i;
		for (i = 0; i < n; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}
}