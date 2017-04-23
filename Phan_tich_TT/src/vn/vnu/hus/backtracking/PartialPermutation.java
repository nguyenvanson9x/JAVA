package vn.vnu.hus.backtracking;

public class PartialPermutation {
	
	private static int n;
	private static int k;
	private static final int X[] = new int[100];
	private static final int B[] = new int[100];

	public static void printResult() {

		for (int i = 0; i < k; i++) {

			System.out.printf("%d ", X[i] + 1);
		}
		System.out.println("");
	}

	public static void permute(int i) {

		for (int j = 0; j < n; j++) {
			if (B[j] == 0) {

				X[i] = j;
				B[j] = 1;
				if (i == k - 1) {
					printResult();
				} else {
					permute(i + 1);
				}
				B[j] = 0;
			}
		}
	}

	public static void main(String[] args) {
		// System.out.println("Nhap n: ");
		n = 5;
		k = 3;
		System.out.println("Cac chinh hop chap " + k + "  cua " + n + "phan tu la: ");
		permute(0);
	}
}
