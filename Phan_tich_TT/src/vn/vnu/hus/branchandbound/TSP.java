package vn.vnu.hus.branchandbound;

public class TSP {
	private static final int C[][] = { { 100, 2, 4, 6 }, { 2, 100, 7, 8 }, { 4, 7, 100, 3 }, { 6, 8, 3, 100 } };
	private static int cMin;
	private static final int[] B = new int[C.length];
	private static final int[] X = new int[C.length];
	private static final int[] X_BEST = new int[C.length];
	private static int f = Integer.MAX_VALUE;
	private static int sum = 0, cost = 0, g = 0;

	public static void findCMin() {
		cMin = C[1][0];
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C.length; j++) {
				if (C[i][j] < cMin && C[i][j] != 0) {
					cMin = C[i][j];
				}
			}
		}
		System.out.println(cMin);
	}

	public static void printResult(int x[]) {
		for (int i = 0; i < C.length; i++) {
			System.out.print(x[i] + 1 + " ");
		}
		System.out.println("");
	}

	public static void update(int p[], int a[]) {

		for (int i = 0; i < a.length; i++) {
			p[i] = a[i];
		}
		f = cost;
	}

	public static void tsp(int i) {
		for (int j = 1; j < C.length; j++) {
			if (B[j] == 0) {
				X[i] = j;
				B[j] = 1;
				sum = sum + C[X[i - 1]][X[i]];
				if (i == C.length - 1) {
					cost = sum + C[X[C.length - 1]][X[0]];
					if (cost < f) {
						update(X_BEST, X);
					}
				} else {
					g = sum + (C.length - i + 1) * cMin;
					if (g < f) {
						tsp(i + 1);
					}
				}
				sum = sum - C[X[i - 1]][X[i]];
				B[j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		X[0] = 0;
		findCMin();
		
		tsp(1);
		printResult(X_BEST);
	}
}
