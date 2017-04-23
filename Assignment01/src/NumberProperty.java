//NguyenVanSon;
//Ender;
public class NumberProperty {

	public static int prime(int n) {
		System.out.println();
		System.out.println();
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

	public static boolean palindrome(int n) {
		String str = String.valueOf(n);
		int l = str.length();
		int i;
		int[] arrayNumber = new int[l + 1];
		for (i = 1; i <= l - 1; i++) {
			arrayNumber[i] = (int) ((n % Math.pow(10, l - i + 1) - n % Math.pow(10, l - i)) / Math.pow(10, l - i));
			arrayNumber[l] = n % 10;
		}
		int begin, end, mid;
		begin = 1;
		end = l;
		mid = (begin + end) / 2;
		for (i = 1; i <= (l+1)/2; i++) {
			if (arrayNumber[i] == arrayNumber[l-i+1]) {
				begin = begin + 1;
				end = end - 1;
			} else
				break;
		}
		if (i == mid + 1) {
			return true;
		} else
			return false;
	}

	public static void maxPalindrome() {
		int i, j, t = 0, max;
		int[] array = new int[999 * 999];
		for (i = 100; i <= 999; i++) {
			for (j = 100; j <= 999; j++) {
				if (palindrome(i * j) == true) {
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

	public static int armstrong(int n) {
		int sum, k;
		k = n;
		sum = 0;
		String s = String.valueOf(n);
		int l = s.length();
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
		System.out.println("	30 so nguyen to dau tien:");
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
		// 30 so Palindrome dau tien.
		System.out.println("	30 so Palindrome dau tien:");
		int j2 = 1;
		for (int i = 0;; i++) {
			if (palindrome(i) == true) {
				System.out.println(i);
				j2++;
			}
			if (j2 == 30) {
				break;
			}
		}
		// 30 so palindrome dau tien la so nguyen to.
		System.out.println("	30 so palindrome dau tien la so nguyen to:");
		int j3 = 1;
		for (int i = 0;; i++) {
			if (prime(i) == 1 && palindrome(i) == true) {
				System.out.println(i);
				j3++;
			}
			if (j3 == 30) {
				break;
			}
		}
		// So palindrome lon nhat la tich cua hai so co 3 chu so;
		System.out.print("	So palindrome lon nhat la tich cua hai so co 3 chu so: ");
		maxPalindrome();
		// Armstrong;
		System.out.println("  30 so Armstrong dau tien:");
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
