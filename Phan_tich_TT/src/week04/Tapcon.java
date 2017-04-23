package week04;

public class Tapcon {
	private static int N, k;
	private static int[] x;

	public static void main(String[] args) {
		N = 5;
		k = 3;
		x = new int[k];
		tapcon(0);
	}

	private static void tapcon(int i) {
		int j;
		for (j = i; j <= N - k + i; j++) {
			x[i] = j + 1;
			if (i < k - 1)
				tapcon(i + 1);
			else
				ket_qua();
		}
	}

	private static void ket_qua() {
		// TODO Auto-generated method stub
		int i, n = x.length;
		for (i = 0; i < n; i++)
			System.out.print(x[i] + " ");
		System.out.println();
	}
}
