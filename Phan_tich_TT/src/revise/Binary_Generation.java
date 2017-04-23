package revise;

public class Binary_Generation {
	private static int k;
	private static int[] x;

	public static void main(String[] args) {
		k = 4;
		x = new int[k];
		BG(0);
	}

	private static void BG(int i) {
		int j;
		for (j = 0; j <= 1; j++) {
			x[i] = j;
			if (i < k - 1)
				BG(i + 1);
			else
				ket_qua();
		}
	}

	private static void ket_qua() {
		int i;
		for (i = 0; i < k; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}
}
