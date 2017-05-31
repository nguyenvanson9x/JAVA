package Revise_14_05_2017;

public class day_con {
	private static int n, j_max;
	private static int[] T, F, A, a = { 1, 9, 4, 10, 5, 6, 8, 2 };

	public static void main(String[] args) {
		n = a.length;
		T = new int[n + 2];
		F = new int[n + 2];

		init();
		create();
		ket_qua();
	}

	private static void create() {
		F[n + 1] = 1;
		int i, j;
		for (i = n; i >= 0; i--) {
			j_max = n + 1;
			for (j = i + 1; j <= n + 1; j++)
				if (F[j] > F[j_max] && A[j] > A[i])
					j_max = j;
			F[i] = F[j_max] + 1;
			T[i] = j_max;
		}
	}

	private static void ket_qua() {
		int i;
		i = T[0];
		while (i < n) {
			System.out.print(A[i] + " ");
			i = T[i];
		}
	}

	private static void init() {
		int i;
		A = new int[n + 2];
		A[0] = -Integer.MAX_VALUE;
		A[n + 1] = Integer.MAX_VALUE;
		for (i = 0; i < n; i++)
			A[i + 1] = a[i];
	}

}
