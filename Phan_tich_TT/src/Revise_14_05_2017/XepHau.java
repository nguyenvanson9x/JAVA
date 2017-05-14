package Revise_14_05_2017;

public class XepHau {
	private static int n;
	private static int[] x, cheo_chinh, cheo_phu, cot;

	public static void main(String[] args) {
		n = 8;
		x = new int[n];
		cheo_chinh = new int[2 * n - 1];
		cheo_phu = new int[2 * n - 1];
		cot = new int[n];
		xep_hau(0);
	}

	private static void xep_hau(int i) {
		int j;
		for (j = 0; j < n; j++) {
			if (cot[j] == 0 && cheo_chinh[i - j + n - 1] == 0 && cheo_phu[i + j] == 0) {
				x[i] = j;
				cot[j] = 1;
				cheo_chinh[i - j + n - 1] = 1;
				cheo_phu[i + j] = 1;

				if (i == n - 1)
					ket_qua();
				else
					xep_hau(i + 1);
				cot[j] = 0;
				cheo_chinh[i - j + n - 1] = 0;
				cheo_phu[i + j] = 0;
			}
		}
	}

	private static void ket_qua() {
		int i;
		for (i = 0; i < n; i++)
			System.out.print(x[i] + 1 + " ");
		System.out.println();

	}
}
