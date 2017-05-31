package Revise_14_05_2017;

public class Tap_Con_Error {
	private static int k, n;
	private static int[] x;
	public static void main(String[] args) {
		k = 3;
		n = 5;
		x = new int[k];
		tap_con(0);
	}
	
	private static void tap_con(int i) {
		int j;
		for (j = i; j <= n - k + i; j++) {
			x[i] = j;
			if (i == k - 1)
				ket_qua();
			else
				tap_con(i + 1);
		}
	}
	
	private static void ket_qua() {
		int i;
		for (i = 0; i < k; i++)
			System.out.print(x[i] + 1 + " ");
		System.out.println();
	}
}
