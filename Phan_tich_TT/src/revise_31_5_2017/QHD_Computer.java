package revise_31_5_2017;

public class QHD_Computer {
	private static int[] L;
	private static int[] s = { 1, 2, 3, 5, 7, 6, 8 };
	private static int[] f = { 4, 4, 4, 6, 8, 9, 9 };
	private static int[] c = { 10, 5, 6, 9, 10, 7, 8 };
	private static int lmax, index, n;
	
	public static void main(String[] args) {
		n = s.length;
		L = new int[n];
		lmax = -Integer.MAX_VALUE;
		index = 0;
		
		qhd();
	}

	private static void qhd() {
		int i, j;
		for (i = 0; i < n; i++) {
			L[i] = c[i];
			for (j = 0; j < i; j++) {
				if (f[j] <= s[i] && L[j] + c[i] >= L[i])
					L[i] = L[j] + c[i];
			}
		}
		
		// --- Truy vet ---
		// get max cost and its index;
		for (i = 0; i < n; i++)
			if (L[i] > lmax) {
				lmax = L[i];
				index = i;
			}
		System.out.print(index + 1 + " ");
		lmax -= c[index];
		for (j = index - 1; j >= 0; j--) {
			if (L[j] == lmax && f[j] <= s[index]) {
				System.out.print(j + 1 + " ");
				lmax -= c[j];
			}
		}
		
	}
}
