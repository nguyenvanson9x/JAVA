package Revise_14_05_2017;

public class QHD_Computer {
	private static int[] L, s = { 1, 2, 3, 5, 7, 6, 8 }, f = { 4, 4, 4, 6, 8,
			9, 9 }, c = { 10, 5, 6, 9, 10, 7, 8 };
	private static int n, lmax, index;

	public static void main(String[] args) {
		n = s.length;
		L = new int[n];
		qhd();
	}

	private static void qhd() {
		int i, j;
		lmax = -Integer.MAX_VALUE;
		for (i = 0; i < n; i++) {
			L[i] = c[i];
			for (j = 0; j < i; j++) {
				if (f[j] <= s[i] && L[i] <= L[j] + c[i])
					L[i] = L[j] + c[i];
			}
		}

		for (i = 0; i < n; i++) {
			if (lmax < L[i]) {
				lmax = L[i];
				index = i;
			}
		}
		System.out.print(index + 1 + " ");
		lmax -= c[index];
		for (j = index - 1; j >= 0; j--) {
			if (L[j] == lmax && f[j] <= s[index]) {
				System.out.print(j + 1 + " ");
				lmax = lmax - c[j];
			}
		}
	}
}
/*
 * co so qhd: Li = ci; 
 * cong thuc truy hoi: Li biet L1, ...L_(i-1) 
 * Li = max(Lj+ci) if 0 < j < i 
 * for (i = 0; i < n; i++) { 
 * if (lmax < l[i]) 
 * lmax = l[i];
 * index = i; 
 * }
 * -> in ra index; 
 * lmax = lmax - c[index] 
 * for (i = index - 1; i >=0; i--) 
 * { if (l[i] == lmax && f[i] <= s[index]) 
 * { in ra i; lmax = lmax - c[i]; 
 * } 
 * }
 */
