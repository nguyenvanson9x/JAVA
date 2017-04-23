package vn.vnu.hus.branchandbound;

// moi loai tien co so luong khong han che
public class ATM {
	private static final int M = 49;
	private static final int T[] = { 20, 10, 5, 2, 1 };

	private static final int X[] = new int[T.length];
	private static final int P[] = new int[T.length];
	private static int sum = 0;
	private static int g = 0;
	private static int count = 0;
	private static int f = 0;

	public static void update(int source[], int destination[]) {
		f = count;
		count = 0;
		for (int i = 0; i < destination.length; i++) {
			source[i] = destination[i];
		}
	}

	public static void printResult() {

		for (int i = 0; i < X.length; i++) {

			System.out.print(P[i] + " ");
		}
		System.out.println(" ");
	}

	public static void atm(int i) {

		int t = (M - sum) / T[i];
		for (int j = t; j >= 0; j--) {

			X[i] = j;
			sum = sum + X[i] * T[i];
			count = count + X[i];

			if (i == T.length - 1 || M - sum <= 0) {
				if (f < count) {
					update(P, X);
				}
			} else {
				g = count + T[i + 1] * (M - sum) / T[i];
				if (g > f) {
					atm(i + 1);
				}
			}
			sum = sum - X[i];
			count = count - X[i];
		}
	}

	public static void main(String[] args) {

		atm(0);
		printResult();
	}

}
