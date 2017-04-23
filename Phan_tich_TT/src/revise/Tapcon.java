package revise;

public class Tapcon {
	private static int N, k;
	private static int[] x;

	public static void main(String[] args) {
		N = 9;
		k = 3;
		x = new int[k + 1];
		x[0] = 0;
		tapcon(1);
	}

	private static void tapcon(int i) {
		int j;
		for (j = x[i - 1] + 1; j <= N - k + i; j++) {
			x[i] = j;
			if (i == k)
				ket_qua();
			else
				tapcon(i + 1);
		}
	}

	private static void ket_qua() {
		int i;
		for (i = 1; i <= k; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}
}
