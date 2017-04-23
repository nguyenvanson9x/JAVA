import java.util.Scanner;

public class V {
	private static Scanner s;

	public static boolean isVampire(int x) {

		while (x < 1000 || x > 10000) {
			System.out.print("x= ");
			x = s.nextInt();
		}
		int d = x % 10;
		int c = ((x - d) / 10) % 10;
		int b = ((x - d - 10 * c) / 100) % 10;
		int a = (x - d - c * 10 - b * 100) / 1000;
		if (x == (10 * a + b) * (10 * c + d)
				|| x == (10 * a + b) * (10 * d + c)
				|| x == (10 * a + c) * (10 * b + d)
				|| x == (10 * a + c) * (10 * d + b)
				|| x == (10 * a + d) * (10 * c + b)
				|| x == (10 * a + d) * (10 * b + c)
				|| x == (10 * b + d) * (10 * c + a)
				|| x == (10 * b + c) * (10 * d + a)
				|| x == (10 * b + a) * (10 * c + d)
				|| x == (10 * b + a) * (10 * d + c)
				|| x == (10 * c + b) * (10 * a + d)
				|| x == (10 * c + a) * (10 * d + b)) {
			return true;
		} else
			return false;
	}

	public static void printStars() {
		for (int i = 0; i <= 20; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		s = new Scanner(System.in);
		int x;
		x = s.nextInt();
		printStars();
		if (isVampire(x) == true) {
			System.out.println("La so vampire");
		} else
			System.out.println("khong la so vampire");
		printStars();
	}
}