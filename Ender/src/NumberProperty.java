//NguyenVanSon;
//Ender;
public class NumberProperty {

	public static int prime(int n) {

		int result = 1;
		if (n <= 0 || n == 1) {
			result = 0;
		} else {
			for (int i = 2; i <= (int) Math.sqrt(n); i++) {
				if (n % i == 0) {
					result = 0;
					break;

				}
			}
		}
		return result;
	}

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

	public static int armstrong(int n) {
		int sum, k;
		k = n;
		sum = 0;
		String s=String.valueOf(n);
		int l=s.length();
		while (k > 0) {
			int temp = k % 10;
			k = k / 10;
			sum = (int) (sum + Math.pow(temp, l));

		}
		if (sum == n) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		// So nguyen to.
		System.out.println("30 so nguyen to dau tien:");
		int j1 = 1;
		for (int i = 1;; i++) {

			if (prime(i) == 1) {
				System.out.println(i);
				j1++;
			}
			if (j1 == 30) {
				break;
			}
		}
		// Palindrome1.
		System.out.println("30 so Palindrome dau tien:");
		int j2 = 1;
		for (int i = 1;; i++) {
			if (palindrome(i) == 1) {
				System.out.println(i);
				j2++;
			}
			if (j2 == 30) {
				break;
			}
		}
		// Palindrome2;
		System.out.println("30 so palindrome dau tien la so nguyen to:");
		int j3 = 1;
		for (int i = 1;; i++) {
			if (prime(i) == 1 && palindrome(i) == 1) {
				System.out.println(i);
				j3++;
			}
			if (j3 == 30) {
				break;
			}
		}
		// Armstrong;
		System.out.println("30 so Armstrong dau tien:");
		int j4 = 1;
		
		for (int i = 0;; i++) {
			if (armstrong(i) == 1) {
				System.out.println(i);
				j4++;
			}
			if (j4 == 30) {
				break;
			}
		}
	}

}
