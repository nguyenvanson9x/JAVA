package Revise_14_05_2017;

public class HaNoi_Tower {
	private static int n;

	public static void main(String[] args) {
		n = 4;
		HN_Tower();
	}

	private static void HN_Tower() {
		move(n, "A", "B", "C");
	}

	private static void move(int k, String A, String B, String C) {
		if (k == 1)
			System.out.println(A + " -> " + B);
		else {
			move(k - 1, A, C, B);
			System.out.println(A + " -> " + B);
			move(k - 1, C, B, A);

		}
	}
}
