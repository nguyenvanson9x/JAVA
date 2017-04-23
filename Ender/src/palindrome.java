public class palindrome {
	public static int checkpalindrome(int z) {
		String s = String.valueOf(z);
		System.out.println(s);
		int l = s.length();
		int i, b, e, mid;
		b = 0;
		e = l - 1;
		mid = (b + e) / 2;
		for (i = b; i <= mid; i++) {
			if (s.charAt(b) == s.charAt(e)) {
				b = b + 1;
				e = e - 1;
			} else
				break;
		}
		if (i == mid + 1) {
			return 1;
		} else
			return 0;
	}

	public static void main(String[] args) {
		int x = 01210;
		if (checkpalindrome(x) == 1) {
			System.out.println(x + " la so palindrome");
		} else
			System.out.println(x + " khong phai so palindrome");

	}
}
