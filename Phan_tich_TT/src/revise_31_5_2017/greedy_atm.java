package revise_31_5_2017;

public class greedy_atm {
	private static int[] t = { 10, 40, 20, 60, 30, 50, 100 };
	private static int S, n;

	public static void main(String[] args) {
		n = t.length;
		S = 150;
		atm();
	}

	private static void atm() {
		sort(t);
		int i = 0, count = 0, sum;
		while (t[i] > S)
			i++;
		sum = S;
		while (i < n && sum > 0) {
			if (sum >= t[i]) {
				sum -= t[i];
				count++;
			}
			i++;
		}
		if (sum == 0)
			System.out.println("So to tien can dung: " + count);
		else
			System.out.println("NOT");
	}

	private static void sort(int[] a) {
		int i, j, l = a.length;
		for (i = 0; i < n - 1; i++)
			for (j = i + 1; j < n; j++)
				if (a[i] < a[j])
					swap(a, i, j);
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
