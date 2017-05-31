package vn.vnu.hus.branchandbound;

public class ABC {

	private static final int MAX = 100;
	private static final char X[] = new char[MAX];
	private static final char X_BEST[] = new char[MAX];
	private static int tMin, n;
	private static int count = 0;

	public static int isSame(int i, int l) // kiem tra hai day con co do dai l
	{
		for (int j = 0; j < l; j++) {
			if (X[i - j] != X[i - j - l]) {
				return 1; // ton tai vi tri lam cho hai day con khac nhau
			}
			
		}
		return 0; // hai day con lien tiep giong nhau
	}

	// kiem tra tinh hop le cua viec chon x[i]
	public static int check(int i) {

		for (int l = 1; l <= (i + 1) / 2; l++) { // xet day con do dai l va chua
													// x[i]
			if (isSame(i, l) == 0) { // ton tai hai day con lien tiep giong nhau
				return 0;
			}
		}
		return 1; // khong ton tai 2 day con lien tiep giong nhau
	}

	public static void update() {
		tMin = count;
		count = 0;
		for (int i = 0; i < n; i++) {
			X_BEST[i] = X[i];
		}
	}

	public static void printResult() {
		for (int i = 0; i < n; i++) {

			System.out.print(X_BEST[i]);
		}
	}

	public static void abc(int i) {
		for (char j = 'A'; j <= 'C'; j++) {
			X[i] = j;
			if (check(i) == 1) {
				count = (j == 'C') ? count + 1 : count;
				if (count + (n - i) / 4 < tMin) {
					if (i == n - 1) {
						update();
					} else {
						abc(i + 1);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		n = 3;
		tMin = n;
		X[0] = 'A';
		abc(1);
		printResult();
	}
}
