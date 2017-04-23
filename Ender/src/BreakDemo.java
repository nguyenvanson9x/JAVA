public class BreakDemo {
	public static void prime(int a) {
		// Kiem tra so nguyen to
		int n = (int) Math.sqrt(a);
		for (int i = 0; i < n; i++) {
			if (a % i == 0) {
				System.out.println(a + " khong la so nguyen to");
			} else {
				System.out.println(a + "la so nguyen to");
			}
		}

	}

	public static void main(String[] args) {
		int a = 7;
		prime(a);
	}
}
