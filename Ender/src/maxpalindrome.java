public class maxpalindrome {
	public static int palindrome(int n) {

		int m, k;

		k = n;
		m = 0;
		while (k > 0) {
			m = 10 * m + k % 10;
			k = (int) k / 10;
		}
		if (n == m) {
			return 1;
		} else {
			return 0;
		}

	}

	public static void printpalindrome() {
		int i, j, t = 0, max;
		int[] array = new int[99 * 99];
		for (i = 10; i <= 99; i++) {
			for (j = 10; j <= 99; j++) {
				if (palindrome(i * j) == 1) {
					array[t] = i * j;
					t++;
				}
			}
		}
		max = array[1];
		for (i = 1; i <= t; i++) {
			if (array[i] >= max) {
				max = array[i];
			}

		}
		System.out.println(max);

	}

	public static void main(String[] args) {
		printpalindrome();
	}
}
