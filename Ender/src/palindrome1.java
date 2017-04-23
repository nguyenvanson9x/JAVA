public class palindrome1 {
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

	public static void main(String[] args) {
		int j2 = 1;
		for (int i = 0;; i++) {
			if (palindrome(i) == true) {
				System.out.println(i);
				j2++;
			}
			if (j2 == 3000) {
				break;
			}
		}
	}
}
