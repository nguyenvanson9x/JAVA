import java.util.Stack;

public class Util {
	private static int d;
	private static Stack<Integer> s = new Stack<Integer>();

	public static void phantich_nguyento(int n) {

		if (n > 0) {
			d = 2;
			if (n == 1)
				System.out.println(n);
			else {
				while (n % d != 0)
					d++;
				System.out.print(d + " ");
				phantich_nguyento(n / d);
			}
		} else
			System.out.println("Input: " + n + " - Error");

	}

	public static void phantich_nguyento_2(int n) {

		while (n > 1) {
			for (int i = 2; i <= n; i++) {
				if (n % i == 0) {
					System.out.print(i + " ");
					n = n / i;
					if (n == 1)
						System.out.print(n);
				}
			}
		}
	}


	public static void intoBinary(int n) {
		if (n > 0) {
			intoBinary(n / 2);
			System.out.print(n % 2);
		}
	}

	public static void intoBinary_2(int n) {
		while (n > 0) {
			s.push(n);
			n = n / 2;
		}
		while (!s.isEmpty()) {
			n = s.pop();
			System.out.print(n % 2);
		}
	}

	public static void HaNoi_Tower(int n, String A, String B, String C) {
		if (n == 1)
			System.out.println(A + " -> " + B);
		else {
			HaNoi_Tower(n - 1, A, C, B);
			System.out.println(A + " -> " + B);
			HaNoi_Tower(n - 1, C, B, A);

		}
	}

	public static void BinarySearch(int[] a, int u, int v, int k) {
		int m = u + (v - u) / 2;
		if (u < v) {
			if (k > a[m])
				BinarySearch(a, m + 1, v, k);
			else if (k < a[m])
				BinarySearch(a, u, m - 1, k);
			else
				System.out.println("Vi tri: " + m);
		} else
			System.out.println("Vi tri: -1");
	}

	public static int BinarySearch_2(int[] a, int u, int v, int k) {
		int m;

		while (u <= v) {
			m = u + (v - u) / 2;
			if (k == a[m])
				return m;
			if (k > a[m])
				u = m + 1;
			else
				v = m - 1;
		}
		return -1;
	}

	public static void sinh_so(int n) {
		int i, last;
		last = 1;
		for (i = 1; i <= n; i++) {
			last = sinh_so_temp(i, last);
		}
	}

	private static int sinh_so_temp(int n, int last) {
		int i, count;
		count = 0;
		i = last;
		while (count < n) {
			if (i % n == 0) {
				System.out.print(i + " ");
				count++;
			}
			i++;
		}
		System.out.println();
		return i;
	}

}
