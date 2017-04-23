import java.util.Scanner;

public class QuadraticEq {

	private static Scanner scan;

	public static void printStars() {
		for (int i = 1; i <= 20; i++) {
			System.out.print("*");

		}
		System.out.println();
	}

	public static void solve(double a, double b, double c) {
		double delta = b * b - 4 * a * c;
		double kq = -b / (2 * a);

		if (a == 0) {
			System.out.println("Khong phai phuong trinh bac hai mot an");
		} else if (delta < 0) {
			System.out.println("Phuong trinh vo nghiem");
		} else if (delta == 0) {
			System.out.println("Phuong trinh co nghiem kep x1 = x2 = " + kq);
		} else {
			double x1, x2;
			x1 = (-b + Math.sqrt(delta)) / (2 * a);
			x2 = (-b - Math.sqrt(delta)) / (2 * a);
			System.out
					.printf("Phuong trinh co hai nghiem phan biet x1 = %.1f va x2 = %.1f",
							x1, x2);
		}

	}

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Nhap vao a,b,c:");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		printStars();
		solve(a, b, c);
		printStars();
	}
}
