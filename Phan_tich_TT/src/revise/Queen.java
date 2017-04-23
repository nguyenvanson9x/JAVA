package revise;

public class Queen {
	private static int n;
	private static int[] x, cot, cheo_chinh, cheo_phu;

	public static void main(String[] args) {
		n = 8;
		x = new int[n];
		cot = new int[n];
		cheo_chinh = new int[2 * n - 1];
		cheo_phu = new int[2 * n - 1];
		xephau(0);
	}

	private static void xephau(int i) {
		int j;
		for (j = 0; j < n; j++)
			if (cot[j] == 0 && cheo_chinh[i - j + n - 1] == 0 && cheo_phu[i + j] == 0) {
				x[i] = j;
				cot[j] = 1;
				cheo_chinh[i - j + n - 1] = 1;
				cheo_phu[i + j] = 1;
				if (i == n - 1)
					ket_qua();
				else
					xephau(i + 1);
				cot[j] = 0;
				cheo_chinh[i - j + n - 1] = 0;
				cheo_phu[i + j] = 0;
			}
	}

	private static void ket_qua() {
		int i;
		for (i = 0; i < n; i++)
			System.out.print(x[i] + 1 +  " ");
		System.out.println();
	}

	private static void init() {
		int i;
		for (i = 0; i < n; i++)
			cot[i] = 0;
		for (i = 0; i < 2 * n - 1; i++) {
			cheo_chinh[i] = 0;
			cheo_phu[i] = 0;
		}
	}
}
