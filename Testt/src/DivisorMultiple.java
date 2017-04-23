import java.util.Scanner;

public class DivisorMultiple {
	private static Scanner scan;

	public static int gcd(int n, int m) {
		int kq = 0;
		n = Math.abs(n);
		m = Math.abs(m);
		while (n * m != 0) {
			if (n > m) {
				n = n % m;
			} else
				m = m % n;
		}
		kq = m + n;
		return kq;

	}

	public static int lcm(int n, int m) {
		int kq;
		kq = (m * n) / gcd(n, m);
		return kq;

	}

	public static void printStars() {
		for (int i = 1; i <= 20; i++) {
			System.out.print("*");

		}
		System.out.println();
	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Nhap vao n,m:");
		int n = scan.nextInt();
		int m = scan.nextInt();
		printStars();
		System.out.println("UCLN cua " + n + " va " + m + " la: " + gcd(n, m));
		System.out.println("BCNN cua " + n + " va " + m + " la: " + lcm(n, m));
		printStars();
	}
}
