package revise;

public class devide_1 {

	public static void main(String[] args) {
		System.out.println(Giai_Thua(3));
		// HaNoiTower(64, "A", "B", "C");
		System.out.println(ucln(10, 5));
		int a[] = { 1, 4, 7, 20, 34, 65, 124 };
		System.out.println(BinarySearch(a, 124, 0, a.length - 1));
		MergeSort(a);
		for (int x : a)
			System.out.print(x + " ");
	}

	private static int Giai_Thua(int n) {
		if (n <= 1)
			return 1;
		return n * Giai_Thua(n - 1);
	}

	@SuppressWarnings("unused")
	private static void HaNoiTower(int n, String a, String b, String c) {
		if (n == 1)
			move(a, b, c);
		else {
			HaNoiTower(n - 1, a, c, b);
			HaNoiTower(1, a, b, c);
			HaNoiTower(n - 1, c, b, a);
		}

	}

	private static void move(String a, String b, String c) {
		System.out.println("Move " + a + " to " + b);
	}

	private static int ucln(int a, int b) {
		if (b == 0)
			return a;
		else
			return ucln(b, a % b);
	}

	private static int BinarySearch(int[] a, int x, int L, int R) {
		if (L == R)
			return (x == a[L]) ? L : -1;
		else {
			int M = L + (R - L) / 2;
			if (x > a[M])
				return BinarySearch(a, x, M + 1, R);
			else if (x < a[M])
				return BinarySearch(a, x, L, M - 1);
			else
				return M;
		}
	}

	private static void MergeSort(int[] a) {
		int[] b = new int[a.length];
		mergeSort(a, b, 0, a.length - 1);
	}

	private static void mergeSort(int[] a, int[] b, int u, int v) {
		int m;
		if (u < v) {
			m = u + (v - u) / 2;
			mergeSort(a, b, u, m);
			mergeSort(a, b, m + 1, v);
			merge(a, b, u, m, v);
		}
	}

	private static void merge(int[] a, int[] b, int u, int m, int v) {
		int k;
		for (k = 0; k < a.length; k++)
			b[k] = a[k];
		int i = u;
		int j = m + 1;
		
		for (k = u; k <= v; k++) {
			if (i > m)
				a[k] = b[j++];
			else if (j > v)
				a[k] = b[i++];
			else if (b[i] > b[j])
				a[k] = b[j++];
			else
				a[k] = b[i++];
		}
		
	}
}
