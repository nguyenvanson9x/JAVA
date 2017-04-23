package demo;

public class prime {
	public static void main(String[] args) {
		System.out.println(check_prime(7));
	}

	private static int check_prime(int a) {
		for (int i = 2; i < a; i++) {
			if (a % i == 0)
				break;
			return 1;
		}

		return 0;
	}
}
